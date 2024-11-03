package com.mshindelar.collection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mshindelar.collection.dto.card.YGOCardDto;
import com.mshindelar.collection.model.Account;
import com.mshindelar.collection.model.card.CardFranchise;
import com.mshindelar.collection.model.collection.Collection;
import com.mshindelar.collection.model.collection.CollectionSettings;
import com.mshindelar.collection.repository.CardRepository;
import com.mshindelar.collection.repository.PrintRepository;
import com.mshindelar.collection.service.util.YGOCardUtil;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceTest {
    @Autowired
    protected CardService cardService;
    @Autowired
    protected CollectionService collectionService;
    @Autowired
    protected AccountService accountService;

    @Autowired
    protected ObjectMapper mapper;

    protected Account testAccount;

    protected Collection testCollection;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        this.cardService.saveCards(YGOCardUtil.getTestCards(mapper));
        testAccount = this.accountService
                .createNewAccount("testAccount");

        CollectionSettings settings = CollectionSettings.withDefaults(CardFranchise.YGO);
        testCollection = this.collectionService.createNewCollection(
                "testCollection", settings, testAccount);
    }

}
