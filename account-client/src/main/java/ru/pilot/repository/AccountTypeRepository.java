package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pilot.entity.AccountType;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{
    Optional<AccountType> findByAccountType(String accountType);
}