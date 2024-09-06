package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.pilot.entity.AccountType;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>, JpaSpecificationExecutor<AccountType> {
    Optional<AccountType> findByAccountType(String accountType);
}