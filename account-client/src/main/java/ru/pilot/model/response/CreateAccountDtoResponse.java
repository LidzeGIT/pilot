package ru.pilot.model.response;

import java.math.BigDecimal;

public record CreateAccountDtoResponse(Integer accountId, String accountType,
                                       long userId, BigDecimal balance,boolean isClosed, String currency, java.time.Instant createdAt) {
}
