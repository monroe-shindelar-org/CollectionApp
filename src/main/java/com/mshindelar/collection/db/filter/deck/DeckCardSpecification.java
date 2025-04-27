package com.mshindelar.collection.db.filter.deck;

import com.mshindelar.collection.db.filter.AbstractFilter;
import com.mshindelar.collection.db.filter.GenericSpecification;
import com.mshindelar.collection.db.filter.JoinDataSupplier;
import com.mshindelar.collection.model.deck.DeckCard;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

import java.util.LinkedHashMap;
import java.util.Map;

public class DeckCardSpecification extends GenericSpecification<DeckCard> {
    public DeckCardSpecification(AbstractFilter filter) {
        super(filter, new DeckCardJoinDataSupplier());
    }

    private static class DeckCardJoinDataSupplier implements JoinDataSupplier<DeckCard> {
        @Override
        public Map<String, Join<Object, Object>> getJoinData(Root<DeckCard> root, CriteriaQuery<?> query) {
            Map<String, Join<Object, Object>> attributeToJoinMap = new LinkedHashMap<>();
            Join<Object, Object> joinCard = root.join("card", JoinType.INNER);
            attributeToJoinMap.put("Card", joinCard);
            return attributeToJoinMap;
        }
    }
}
