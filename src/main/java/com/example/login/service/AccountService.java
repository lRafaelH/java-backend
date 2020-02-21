package com.example.login.service;

import com.example.login.model.Account;
import com.example.login.repository.AccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccRepo accRepo;

public Account addAccount(Account account) {
    return accRepo.save(account);
}

public Optional<Account> findAccount(String username) {
    return accRepo.findByUsername(username);
}
}
