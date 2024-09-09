package ru.pilot.exception;

public class AccountTypeNotFoundException extends RuntimeException {
    public AccountTypeNotFoundException() {
        super("AccountType not found");
    }
}
