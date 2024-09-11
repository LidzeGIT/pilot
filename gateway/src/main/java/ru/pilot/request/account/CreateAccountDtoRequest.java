package ru.pilot.request.account;

public record CreateAccountDtoRequest(String accountType, Integer customerId, String currency, double initialDeposit) {
}
