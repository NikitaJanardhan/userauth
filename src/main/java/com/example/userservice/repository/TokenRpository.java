package com.example.userservice.repository;

import com.example.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository

public interface TokenRpository extends JpaRepository<Token,Long> {

    Optional<Token> findByValueAndIsDeletedEquals(String token, boolean isDeleted);
    Optional<Token> findByValueAndIsDeletedEqualsAndExpirydateGreaterThan(
            String token, boolean isDeleted,Date expiryDate);


}
