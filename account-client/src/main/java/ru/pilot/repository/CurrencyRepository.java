package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pilot.entity.Currency;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByCurrencyCode(String currencyCode);
}