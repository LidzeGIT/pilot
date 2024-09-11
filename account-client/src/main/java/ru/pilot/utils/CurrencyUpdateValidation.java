package ru.pilot.utils;

import ru.pilot.entity.Account;
import ru.pilot.entity.Currency;
import ru.pilot.exception.UpdateValidationError;

public class CurrencyUpdateValidation implements UpdateValidation {
    private final Account account;
    private final Currency currency;

    public CurrencyUpdateValidation(Account account, Currency currency) {
        this.account = account;
        this.currency = currency;
    }

    @Override
    public boolean isValid() {
        if (account == null || currency == null) {
            throw new UpdateValidationError("Account or currency can't be null.");
        }
        if (account.getCurrency().getCurrencyCode().equals(currency.getCurrencyCode())) {
            throw new UpdateValidationError("Currency code already exists for this account.");
        }
        return true;
    }
}
