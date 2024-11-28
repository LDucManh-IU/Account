package com.pdm.farming.Repository;

import com.pdm.farming.Entities.Account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Find account by username
    Optional<Account> findByUsername(String username);

    // Find account by email
    Optional<Account> findByEmail(String email);

    // Check if an account exists by username
    boolean existsByUsername(String username);

    // Check if an account exists by email
    boolean existsByEmail(String email);
}
