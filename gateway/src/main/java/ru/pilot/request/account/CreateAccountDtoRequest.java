package ru.pilot.request.account;

public record CreateAccountDtoRequest(String accountType, Integer userId, String currency, double initialDeposit) {
}
