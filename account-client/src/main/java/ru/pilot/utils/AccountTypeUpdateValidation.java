package ru.pilot.utils;

import ru.pilot.entity.Account;
import ru.pilot.entity.AccountType;
import ru.pilot.exception.UpdateValidationError;

public class AccountTypeUpdateValidation implements UpdateValidation {
    private final Account account;
    private final AccountType accountType;

    public AccountTypeUpdateValidation(Account account, AccountType accountType) {
        this.account = account;
        this.accountType = accountType;
    }

    @Override
    public boolean isValid() {
        if (account == null || accountType == null) {
            throw new UpdateValidationError("Account or account type can't be null.");
        }
        if (account.getAccountType().getAccountType().equals(accountType.getAccountType())) {
            throw new UpdateValidationError("Account type code already exists for this account.");
        }
        return true;
    }
}
