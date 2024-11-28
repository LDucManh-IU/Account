package com.pdm.farming.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdm.farming.Entities.Account;
import com.pdm.farming.Repository.AccountRepository;

import java.util.List;
import java.util.Optional;


@Service

public class AccountService {

 @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Create a new account
    public Account createAccount(Account account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new IllegalArgumentException("Username already exists!");
        }
        if (accountRepository.existsByEmail(account.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }
        return accountRepository.save(account);
    }

    // Find an account by username
    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    // Find an account by email
    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    // Delete an account by ID
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    // Update account details
    public Account updateAccount(Long accountId, Account updatedAccount) {
        return accountRepository.findById(accountId).map(existingAccount -> {
            existingAccount.setUsername(updatedAccount.getUsername());
            existingAccount.setEmail(updatedAccount.getEmail());
            existingAccount.setPassword(updatedAccount.getPassword());
            existingAccount.setAccountRole(updatedAccount.getAccountRole());
            return accountRepository.save(existingAccount);
        }).orElseThrow(() -> new IllegalArgumentException("Account not found!"));
    }
 
}
