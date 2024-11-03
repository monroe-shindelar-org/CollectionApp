package com.mshindelar.collection.service;

import com.mshindelar.collection.exception.NoSuchAccountException;
import com.mshindelar.collection.model.Account;
import com.mshindelar.collection.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account createNewAccount(String username) {
        //TODO: Username sanitization
        return saveAccount(new Account.Builder()
                .withName(username)
                .build());

    }

    public Account getAccountMustExist(UUID id) throws NoSuchAccountException {
        return getAccount(id).orElseThrow(() ->
                new NoSuchAccountException(String.format("Account with ID %s does not exist", id)));
    }

    public Account getAccountMustExist(String username) throws NoSuchAccountException {
        return getAccount(username).orElseThrow(() ->
                new NoSuchAccountException(String.format("Account with username %s does not exist", username)));
    }

    public Optional<Account> getAccount(UUID id) {
        return this.repository.findById(id);
    }

    public Optional<Account> getAccount(String username) {
        return this.repository.findByUsername(username);
    }

    private Account saveAccount(Account account) {
         return this.repository.save(account);
    }
}
