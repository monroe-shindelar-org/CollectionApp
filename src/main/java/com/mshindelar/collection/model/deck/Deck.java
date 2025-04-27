package com.mshindelar.collection.model.deck;

import com.mshindelar.collection.dto.card.DeckCardComparator;
import com.mshindelar.collection.dto.deck.DeckCardDto;
import com.mshindelar.collection.dto.deck.DeckDto;
import com.mshindelar.collection.model.Account;
import com.mshindelar.collection.model.DaoConverter;
import com.mshindelar.collection.model.card.ygo.YGOCard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deck implements Serializable, DaoConverter<DeckDto> {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account owner;

    private String name;

    @Enumerated(EnumType.STRING)
    private DeckType type;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeckCard> cards;

    @Override
    public DeckDto convertToDto(ModelMapper modelMapper) {
        DeckDto deckDTO = new DeckDto();
        deckDTO.setId(this.id);
        deckDTO.setOwnerId(this.getOwner().getId());
        deckDTO.setName(this.name);

        List<DeckCardDto> main = new ArrayList<>();
        List<DeckCardDto> side = new ArrayList<>();
        List<DeckCardDto> extra = new ArrayList<>();

        this.cards.forEach(dc -> {
//            if (c.getIsSided()) {
//                side.put(c.getId(), dc.convertToDto(modelMapper));
//            }
            main.add(dc.convertToDto(modelMapper));

        });

        main.sort(new DeckCardComparator());
        deckDTO.setMain(main);

        return deckDTO;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(id, deck.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
