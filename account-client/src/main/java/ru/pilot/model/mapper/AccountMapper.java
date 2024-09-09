package ru.pilot.model.mapper;

import org.mapstruct.*;
import ru.pilot.entity.Account;
import ru.pilot.entity.AccountType;
import ru.pilot.entity.Currency;
import ru.pilot.exception.UpdateValidationError;
import ru.pilot.model.response.CreateAccountDtoResponse;
import ru.pilot.utils.AccountTypeUpdateValidation;
import ru.pilot.utils.CurrencyUpdateValidation;
import ru.pilot.utils.UpdateValidation;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountType", source = "accountType")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "currency", source = "currency")
    Account toEntity(AccountType accountType, Integer userId, boolean isDeleted, BigDecimal balance, Currency currency);

    @Mapping(target = "accountId", source = "id")
    @Mapping(target = "accountType", source = "accountType.accountType")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "isClosed", source = "isDeleted")
    @Mapping(target = "currency", source = "currency.currencyCode")
    @Mapping(target = "createdAt", source = "createdAt")
    CreateAccountDtoResponse toDto(Account account);

    default Account updateCurrencyAndAccountType(Account account, AccountType accountType, Currency currency) {
        UpdateValidation currencyValidator = new CurrencyUpdateValidation(account, currency);
        UpdateValidation accountTypeValidator = new AccountTypeUpdateValidation(account, accountType);

        if (!(currencyValidator.isValid() && accountTypeValidator.isValid())) {
            throw new UpdateValidationError("Validation failed.");
        }

        account.setCurrency(currency);
        account.setAccountType(accountType);
        return account;
    }

}