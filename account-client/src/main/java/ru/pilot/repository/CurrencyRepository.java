package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.pilot.entity.Currency;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer>, JpaSpecificationExecutor<Currency> {
    Optional<Currency> findByCurrencyCode(String currencyCode);
}