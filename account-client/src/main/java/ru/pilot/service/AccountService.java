package ru.pilot.service;

import org.springframework.stereotype.Service;
import ru.pilot.entity.Account;
import ru.pilot.entity.AccountType;
import ru.pilot.entity.Currency;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;
import ru.pilot.repository.AccountRepository;
import ru.pilot.repository.AccountTypeRepository;
import ru.pilot.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountTypeRepository accountTypeRepository;

    private final CurrencyRepository currencyRepository;

    public AccountService(AccountRepository accountRepository,
                          AccountTypeRepository accountTypeRepository,
                          CurrencyRepository currencyRepository) {
        this.accountRepository = accountRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.currencyRepository = currencyRepository;
    }


    public CreateAccountDtoResponse createAccounts(CreateAccountDtoRequest createAccountDto) {
        Optional<AccountType> byAccountType = accountTypeRepository.findByAccountType(createAccountDto.accountType());
        Optional<Currency> byCurrencyCode = currencyRepository.findByCurrencyCode(createAccountDto.currency());

        Account account = new Account(byAccountType.get(), createAccountDto.userId(), false,
                BigDecimal.valueOf(createAccountDto.initialDeposit()), byCurrencyCode.get());

        account = accountRepository.save(account);

        return new CreateAccountDtoResponse(account.getId(), account.getAccountType().getAccountType(), account.getUserId(),
                account.getBalance(), account.getDeleted(), account.getCurrency().getCurrencyCode()
                , account.getCreatedAt());
    }

    public void deleteAccount(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        account.get().setDeleted(true);
        accountRepository.save(account.get());
    }

    public CreateAccountDtoResponse updateAccount(UpdateAccountDtoRequest changeAccountDtoRequest, long accountId) {
        return null;
    }

    public List<CreateAccountDtoResponse> getAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> new CreateAccountDtoResponse(
                        account.getId(),
                        account.getAccountType() != null ? account.getAccountType().getAccountType() : null,
                        account.getUserId(),
                        account.getBalance(),
                        account.getDeleted(),
                        account.getCurrency() != null ? account.getCurrency().getCurrencyCode() : null,
                        account.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public CreateAccountDtoResponse getAccounts(Integer accountId) {
        Account account = accountRepository.findById(accountId).get();
        return new CreateAccountDtoResponse(account.getId(), account.getAccountType().getAccountType(), account.getUserId(),
                account.getBalance(),account.getDeleted(), account.getCurrency().getCurrencyCode(), account.getCreatedAt());
    }

}
