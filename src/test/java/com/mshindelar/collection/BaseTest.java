package com.mshindelar.collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mshindelar.collection.model.Account;
import com.mshindelar.collection.model.card.CardFranchise;
import com.mshindelar.collection.model.collection.Collection;
import com.mshindelar.collection.model.collection.CollectionSettings;
import com.mshindelar.collection.service.AccountService;
import com.mshindelar.collection.service.CardService;
import com.mshindelar.collection.service.CollectionService;
import com.mshindelar.collection.util.YGOCardUtil;
import org.junit.jupiter.api.BeforeEach;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseTest {
    @Autowired
    protected CardService cardService;
    @Autowired
    protected CollectionService collectionService;
    @Autowired
    protected AccountService accountService;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected ModelMapper modelMapper;

    protected Account testAccount;

    protected Collection testCollection;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        this.cardService.saveCards(YGOCardUtil.getTestCards(objectMapper));
        testAccount = this.accountService
                .createNewAccount("testAccount");

        CollectionSettings settings = CollectionSettings.withDefaults(CardFranchise.YGO);
        testCollection = this.collectionService.createNewCollection(
                "testCollection", settings, testAccount);
    }
}
