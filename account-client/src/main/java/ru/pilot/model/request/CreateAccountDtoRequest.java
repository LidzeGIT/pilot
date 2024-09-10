package ru.pilot.model.request;

public record CreateAccountDtoRequest(String accountType, Integer customerId, String currency, double initialDeposit) {
}
