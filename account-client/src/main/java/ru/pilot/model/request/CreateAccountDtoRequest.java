package ru.pilot.model.request;

public record CreateAccountDtoRequest(String accountType, Integer userId, String currency, double initialDeposit) {
}
