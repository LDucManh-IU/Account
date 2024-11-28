package com.pdm.farming.Controller;

import com.pdm.farming.Entities.Account;
import com.pdm.farming.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class Controller {

    @Autowired
    private AccountService accountService;

    @GetMapping
public ResponseEntity<List<Account>> getAllAccounts() {
    List<Account> accounts = accountService.getAllAccounts();
    return ResponseEntity.ok(accounts);
}

    // Create an account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // Get account by username
    @GetMapping("/username/{username}")
    public Optional<Account> getAccountByUsername(@PathVariable String username) {
        return accountService.getAccountByUsername(username);
    }

    // Get account by email
    @GetMapping("/email/{email}")
    public Optional<Account> getAccountByEmail(@PathVariable String email) {
        return accountService.getAccountByEmail(email);
    }

    // Delete an account
    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }

    // Update an account
    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody Account updatedAccount) {
        return accountService.updateAccount(accountId, updatedAccount);

    }
}