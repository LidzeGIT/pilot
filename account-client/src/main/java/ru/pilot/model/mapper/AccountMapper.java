package ru.pilot.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pilot.entity.Account;
import ru.pilot.entity.AccountType;
import ru.pilot.entity.Currency;
import ru.pilot.model.response.CreateAccountDtoResponse;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountType", source = "accountType")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "currency", source = "currency")
    Account createAccountDtoRequestToAccount(AccountType accountType, Integer userId, boolean isDeleted, BigDecimal balance, Currency currency);

    @Mapping(target = "accountId", source = "id")
    @Mapping(target = "accountType", source = "accountType.accountType")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "isClosed", source = "isDeleted")
    @Mapping(target = "currency", source = "currency.currencyCode")
    @Mapping(target = "createdAt", source = "createdAt")
    CreateAccountDtoResponse accountToCreateAccountDtoResponse(Account account);

}