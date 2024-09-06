package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.pilot.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    @Override
    Optional<Account> findById(Integer accountId);

    @Override
    void deleteById(Integer accountId);

}