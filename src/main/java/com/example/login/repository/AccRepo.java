package com.example.login.repository;

import com.example.login.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccRepo extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsername (String username);
}
