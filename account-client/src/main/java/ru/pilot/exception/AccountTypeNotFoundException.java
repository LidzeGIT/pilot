package ru.pilot.exception;

public class AccountTypeNotFoundException extends Exception {
    public AccountTypeNotFoundException(String formatted) {
        super("Invalid account type: ".concat(formatted));
    }
}
