package ru.pilot.service;

import org.springframework.stereotype.Service;
import ru.pilot.entity.Account;
import ru.pilot.entity.AccountType;
import ru.pilot.entity.Currency;
import ru.pilot.exception.AccountNotFoundException;
import ru.pilot.exception.AccountTypeNotFoundException;
import ru.pilot.exception.CurrencyNotFoundException;
import ru.pilot.model.mapper.AccountMapper;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;
import ru.pilot.repository.AccountRepository;
import ru.pilot.repository.AccountTypeRepository;
import ru.pilot.repository.CurrencyRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository,
                          AccountTypeRepository accountTypeRepository,
                          CurrencyRepository currencyRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.currencyRepository = currencyRepository;
        this.accountMapper = accountMapper;
    }

    public CreateAccountDtoResponse createAccounts(CreateAccountDtoRequest createAccountDto) {
        AccountType accountType = accountTypeRepository.findByAccountType(createAccountDto.accountType())
                .orElseThrow(AccountTypeNotFoundException::new);
        Currency currency = currencyRepository.findByCurrencyCode(createAccountDto.currency())
                .orElseThrow(CurrencyNotFoundException::new);
        Account account = accountMapper.toEntity(accountType, createAccountDto.userId(), false,
                BigDecimal.valueOf(createAccountDto.initialDeposit()), currency);
        account = accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    public void deleteAccount(Integer accountId) {
        accountRepository.findById(accountId).ifPresentOrElse(
                account -> {
                    account.setIsDeleted(true);
                    accountRepository.save(account);
                },
                () -> {
                    throw new AccountNotFoundException();
                });
    }

    public CreateAccountDtoResponse updateAccount(UpdateAccountDtoRequest changeAccountDtoRequest, Integer accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        AccountType accountType = accountTypeRepository.findByAccountType(changeAccountDtoRequest.accountType())
                .orElseThrow(AccountTypeNotFoundException::new);
        Currency currency = currencyRepository.findByCurrencyCode(changeAccountDtoRequest.currency())
                .orElseThrow(CurrencyNotFoundException::new);

        account = accountMapper.updateCurrencyAndAccountType(account, accountType, currency);
        return accountMapper.toDto(accountRepository.save(account));
    }

    public List<CreateAccountDtoResponse> getAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    public CreateAccountDtoResponse getAccounts(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        return accountMapper.toDto(account);
    }
}
