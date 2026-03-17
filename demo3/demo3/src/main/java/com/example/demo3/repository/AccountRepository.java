package com.example.demo3.repository;

import java.util.Optional;

import com.example.demo3.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.login_name = :login_name")
    Optional<Account> findByLoginName(String login_name);
}