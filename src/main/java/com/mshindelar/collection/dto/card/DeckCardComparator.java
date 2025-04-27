package com.mshindelar.collection.dto.card;

import com.mshindelar.collection.dto.deck.DeckCardDto;

import java.util.Comparator;

public class DeckCardComparator implements Comparator<DeckCardDto> {
    private static final String EFFECT_MONSTER = "Effect Monster";
    private static final String FLIP_EFFECT_MONSTER = "Flip Effect Monster";
    private static final String FLIP_TUNER_EFFECT_MONSTER = "Flip Tuner Effect Monster";
    private static final String FUSION_MONSTER = "Fusion Monster";
    private static final String GEMINI_MONSTER = "Gemini Monster";
    private static final String LINK_MONSTER = "Link Monster";
    private static final String NORMAL_MONSTER = "Normal Monster";
    private static final String NORMAL_TUNER_MONSTER = "Normal Tuner Monster";
    private static final String PENDULUM_EFFECT_FUSION_MONSTER = "Pendulum Effect Fusion Monster";
    private static final String PENDULUM_EFFECT_MONSTER = "Pendulum Effect Monster";
    private static final String PENDULUM_EFFECT_RITUAL_MONSTER = "Pendulum Effect Ritual Monster";
    private static final String PENDULUM_FLIP_EFFECT_MONSTER = "Pendulum Flip Effect Monster";
    private static final String PENDULUM_NORMAL_MONSTER = "Pendulum Normal Monster";
    private static final String PENDULUM_TUNER_EFFECT_MONSTER = "Pendulum Tuner Effect Monster";
    private static final String RITUAL_EFFECT_MONSTER = "Ritual Effect Monster";
    private static final String RITUAL_MONSTER = "Ritual Monster";
    private static final String SPELL_CARD = "Spell Card";
    private static final String SPIRIT_MONSTER = "Spirit Monster";
    private static final String SYNCHRO_MONSTER = "Synchro Monster";
    private static final String SYNCHRO_PENDULUM_EFFECT_MONSTER = "Synchro Pendulum Effect Monster";
    private static final String SYNCHRO_TUNER_MONSTER = "Synchro Tuner Monster";
    private static final String TOON_MONSTER = "Toon Monster";
    private static final String TRAP_CARD = "Trap Card";
    private static final String TUNER_MONSTER = "Tuner Monster";
    private static final String UNION_EFFECT_MONSTER = "Union Effect Monster";
    private static final String XYZ_MONSTER = "XYZ Monster";
    private static final String XYZ_PENDULUM_EFFECT_MONSTER = "XYZ Pendulum Effect Monster";


    @Override
    public int compare(DeckCardDto o1, DeckCardDto o2) {
        int o1TypeValue = getTypeValue((YGOCardDto) o1.getCard());
        int o2TypeValue = getTypeValue((YGOCardDto) o2.getCard());

        if (o1TypeValue == o2TypeValue) {
            return o1.getCard().getName().compareTo(o2.getCard().getName());
        } else {
            return Integer.compare(o1TypeValue, o2TypeValue);
        }
    }

    private int getTypeValue(YGOCardDto card) {
        return switch (card.getType()) {
            case NORMAL_MONSTER, NORMAL_TUNER_MONSTER, PENDULUM_NORMAL_MONSTER, RITUAL_MONSTER -> 0;
            case EFFECT_MONSTER, FLIP_EFFECT_MONSTER, FLIP_TUNER_EFFECT_MONSTER, GEMINI_MONSTER,
                 PENDULUM_EFFECT_MONSTER, PENDULUM_EFFECT_RITUAL_MONSTER, PENDULUM_FLIP_EFFECT_MONSTER,
                 PENDULUM_TUNER_EFFECT_MONSTER, RITUAL_EFFECT_MONSTER, SPIRIT_MONSTER, TOON_MONSTER, TUNER_MONSTER,
                 UNION_EFFECT_MONSTER -> 1;
            case SPELL_CARD -> 2;
            case TRAP_CARD -> 3;
            case FUSION_MONSTER, PENDULUM_EFFECT_FUSION_MONSTER -> 4;
            case SYNCHRO_MONSTER, SYNCHRO_TUNER_MONSTER, SYNCHRO_PENDULUM_EFFECT_MONSTER -> 5;
            case XYZ_MONSTER, XYZ_PENDULUM_EFFECT_MONSTER -> 6;
            case LINK_MONSTER -> 7;
            default -> Integer.MAX_VALUE;
        };
    }
}
