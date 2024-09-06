package ru.pilot.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AccountMapper accountMapper;

    public CreateAccountDtoResponse createAccounts(CreateAccountDtoRequest createAccountDto) {
        AccountType accountType = accountTypeRepository.findByAccountType(createAccountDto.accountType())
                .orElseThrow(() -> new IllegalArgumentException("AccountType not found"));

        Currency currency = currencyRepository.findByCurrencyCode(createAccountDto.currency())
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

        Account account = accountMapper.createAccountDtoRequestToAccount(accountType, createAccountDto.userId(), false,
                BigDecimal.valueOf(createAccountDto.initialDeposit()), currency);

        account = accountRepository.save(account);

        return accountMapper.accountToCreateAccountDtoResponse(account);
    }

    public void deleteAccount(Integer accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        account.get().setIsDeleted(true);
        accountRepository.save(account.get());
    }

    public CreateAccountDtoResponse updateAccount(UpdateAccountDtoRequest changeAccountDtoRequest, long accountId) {
        return null;
    }

    public List<CreateAccountDtoResponse> getAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> accountMapper.accountToCreateAccountDtoResponse(account))
                .collect(Collectors.toList());
    }

    public CreateAccountDtoResponse getAccounts(Integer accountId) {
        Account account = accountRepository.findById(accountId).get();
        return accountMapper.accountToCreateAccountDtoResponse(account);
    }

}
