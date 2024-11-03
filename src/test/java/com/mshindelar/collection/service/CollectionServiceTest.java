package com.mshindelar.collection.service;

import com.mshindelar.collection.exception.InvalidCollectionItemException;
import com.mshindelar.collection.exception.NoSuchCardException;
import com.mshindelar.collection.exception.NoSuchCollectionException;
import com.mshindelar.collection.model.card.*;
import com.mshindelar.collection.model.collection.*;
import com.mshindelar.collection.model.collection.request.CollectionOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CollectionServiceTest extends BaseServiceTest {


    @Test
    public void testCreateNewCollection() throws Exception {
        CollectionSettings settings = CollectionSettings.withDefaults(CardFranchise.YGO);
        String name = "collection";

        Collection actual =
                this.collectionService.createNewCollection(name, settings, testAccount);

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(settings, actual.getSettings());
        Assertions.assertEquals(testAccount, actual.getOwner());
    }

    @Test
    public void testAddItemsToCollection() throws Exception {

        Assertions.assertNotNull(testCollection);

        List<Print> prints = List.of(
                cardService.getPrint("ABYR-EN020", "(ScR)"),
                cardService.getPrint("CBLZ-EN083", "(UtR)"),
                cardService.getPrint("SHVA-EN037", "(SR)"),
                cardService.getPrint("ABYR-EN046", "(UtR)"));

        List<CollectionPrintOccurrence> occurrences = getCollectionPrintOccurrenceForPrints(prints);

        occurrences.forEach(o -> {
            Assertions.assertNotNull(o);
            o.setQuantity(3);
        });

        collectionService.updateItemsInCollection(occurrences);

        Collection actual = collectionService.getCollection(testCollection.getId());
        Assertions.assertEquals(3, actual.getItems().size());

        CollectionCard cCard = collectionService.getCollectionCard(testCollection.getId(), prints.get(0).getCard());
        Assertions.assertEquals(2, cCard.getPrints().size());
    }

    @Test
    public void testRemoveItemsForCollection_Remove_LessThanTotal() throws Exception {
        Print megalo = cardService.getPrint("ABYR-EN020", "(ScR)");
        Print teus = cardService.getPrint("CBLZ-EN083", "(UtR)");

        List<CollectionPrintOccurrence> occurrences = getCollectionPrintOccurrenceForPrints(List.of(megalo, teus));
        this.collectionService.updateItemsInCollection(occurrences);

        CollectionPrintOccurrence megaloOccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        CollectionPrintOccurrence teusOccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        Assertions.assertNotNull(megaloOccurrence);
        Assertions.assertNotNull(teusOccurrence);

        megaloOccurrence = this.collectionService.modifyCollectionItem(testCollection.getId(), megalo.getId(), megalo.getSetRarityCode(),
                Condition.NEAR_MINT, Edition.FIRST, -1, 1, CollectionOperation.REMOVE, false);
        teusOccurrence = this.collectionService.modifyCollectionItem(testCollection.getId(), teus.getId(), teus.getSetRarityCode(),
                Condition.NEAR_MINT, Edition.FIRST, -1, 2, CollectionOperation.REMOVE, false);


        collectionService.updateItemsInCollection(List.of(megaloOccurrence, teusOccurrence));

        megaloOccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        teusOccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                teus,
                Condition.NEAR_MINT,
                Edition.FIRST);

        Assertions.assertNotNull(megaloOccurrence);
        Assertions.assertNotNull(teusOccurrence);
        Assertions.assertEquals(2, megaloOccurrence.getQuantity());
        Assertions.assertEquals(1, teusOccurrence.getQuantity());
    }

    @Test
    public void testRemoveItemsForCollection_Remove_MoreThanTotal() throws Exception {
        Print megalo = cardService.getPrint("ABYR-EN020", "(ScR)");
        Print teusUtr = cardService.getPrint("CBLZ-EN083", "(UtR)");
        Print teusUr = cardService.getPrint("CBLZ-EN083", "(UR)");


        List<CollectionPrintOccurrence> occurrences = getCollectionPrintOccurrenceForPrints(List.of(megalo, teusUtr, teusUr));
        this.collectionService.updateItemsInCollection(occurrences);

        CollectionPrintOccurrence megaloOccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        CollectionPrintOccurrence teusUtROccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        CollectionPrintOccurrence teusUROccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                megalo,
                Condition.NEAR_MINT,
                Edition.FIRST);

        Assertions.assertNotNull(megaloOccurrence);
        Assertions.assertNotNull(teusUtROccurrence);
        Assertions.assertNotNull(teusUROccurrence);

        this.collectionService.modifyCollectionItem(testCollection.getId(), megalo.getId(),
                megalo.getSetRarityCode(), Condition.NEAR_MINT, Edition.FIRST, -1, 4,
                CollectionOperation.REMOVE, false);

        this.collectionService.modifyCollectionItem(testCollection.getId(), teusUr.getId(),
                teusUr.getSetRarityCode(), Condition.NEAR_MINT, Edition.FIRST, -1, 3,
                CollectionOperation.REMOVE, false);

        Assertions.assertThrows(NoSuchCollectionException.class,
                () -> this.collectionService.getCollectionPrintOccurrence(
                        testCollection.getId(),
                        megalo,
                        Condition.NEAR_MINT,
                        Edition.FIRST));

        Assertions.assertThrows(NoSuchCollectionException.class,
                () -> this.collectionService.getCollectionPrintOccurrence(
                        testCollection.getId(),
                        teusUr,
                        Condition.NEAR_MINT,
                        Edition.FIRST));

        teusUtROccurrence = this.collectionService.getCollectionPrintOccurrence(
                testCollection.getId(),
                teusUtr,
                Condition.NEAR_MINT,
                Edition.FIRST);

        Assertions.assertNotNull(teusUtROccurrence);
        Assertions.assertEquals(3, teusUtROccurrence.getQuantity());

        Assertions.assertThrows(NoSuchCollectionException.class,
                () -> this.collectionService.getCollectionCard(testCollection.getId(), megalo.getCard()));

        CollectionCard teusCard = this.collectionService.getCollectionCard(testCollection.getId(), teusUtr.getCard());
        Assertions.assertNotNull(teusCard);
        Assertions.assertEquals(1, teusCard.getPrints().size());
        Assertions.assertEquals(teusCard.getPrints().get(0).getPrint().getId(), teusUtr.getId());
        Assertions.assertEquals(teusCard.getPrints().get(0).getPrint().getSetRarityCode(), teusUtr.getSetRarityCode());
    }

    @Test
    public void testRemoveItemsForCollection_Remove_CardNotInCollection() throws Exception {
        Print megalo = cardService.getPrint("ABYR-EN020", "(ScR)");

        Assertions.assertThrows(NoSuchCollectionException.class,
                () -> this.collectionService.modifyCollectionItem(testCollection.getId(), megalo.getId(),
                        megalo.getSetRarityCode(), Condition.NEAR_MINT, Edition.FIRST, -1, 4,
                        CollectionOperation.REMOVE, false));
    }

    @Test
    public void testModifyItemsForCollection_Add_InvalidPrint() throws Exception {
        Assertions.assertThrows(NoSuchCardException.class,
                () -> this.collectionService.modifyCollectionItem(testCollection.getId(), "IVLD-EN000",
                        "(UtR)", Condition.NEAR_MINT, Edition.FIRST, -1, 3,
                        CollectionOperation.ADD));
    }

    @Test
    public void testModifyItemsForCollection_Add_InvalidGrade() throws Exception {
        Print megalo = this.cardService.getPrint("ABYR-EN020", "(ScR)");

        Assertions.assertThrows(InvalidCollectionItemException.class,
                () -> this.collectionService.modifyCollectionItem(testCollection.getId(), megalo.getId(),
                        megalo.getSetRarityCode(), Condition.NEAR_MINT, Edition.FIRST, 10, 3,
                        CollectionOperation.ADD));

        Assertions.assertThrows(InvalidCollectionItemException.class,
                () -> this.collectionService.modifyCollectionItem(testCollection.getId(), megalo.getId(),
                        megalo.getSetRarityCode(), Condition.GRADE, Edition.FIRST, -1, 3,
                        CollectionOperation.ADD));
    }

    private List<CollectionPrintOccurrence> getCollectionPrintOccurrenceForPrints(List<Print> prints) {
        return this.getCollectionPrintOccurrenceForPrints(prints, testCollection);
    }
    private List<CollectionPrintOccurrence> getCollectionPrintOccurrenceForPrints(List<Print> prints, Collection collection) {
        return prints.stream()
                .map(p -> {
                    try {
                        CollectionPrintOccurrence occurrence = collectionService
                                .getOrCreateCollectionPrintOccurrence(collection.getId(), p, Condition.NEAR_MINT, Edition.FIRST);
                        occurrence.setQuantity(3);
                        return occurrence;
                    } catch (NoSuchCollectionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}