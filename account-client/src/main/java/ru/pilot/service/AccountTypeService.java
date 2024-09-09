package ru.pilot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.pilot.entity.AccountType;
import ru.pilot.model.request.AccountTypeDtoRequest;
import ru.pilot.repository.AccountTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeService(AccountTypeRepository accountTypeRepository,
                              ObjectMapper objectMapper) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountType> getList() {
        return accountTypeRepository.findAll();
    }

    public AccountType getOne(Integer id) {
        Optional<AccountType> accountTypeOptional = accountTypeRepository.findById(id);
        return accountTypeOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account type with id `%s` not found".formatted(id)));
    }

    public List<AccountType> getMany(List<Integer> ids) {
        return accountTypeRepository.findAllById(ids);
    }

    public AccountType create(AccountTypeDtoRequest accountType) {
        AccountType type = new AccountType(accountType.accountType());
        Optional<AccountType> accountTypeOptional = accountTypeRepository.findByAccountType(accountType.accountType());
        return accountTypeOptional.orElseGet(() -> accountTypeRepository.save(type));
    }

    public AccountType patch(Integer id, AccountTypeDtoRequest accountTypeDtoRequest)  {
        AccountType accountType = accountTypeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account type with id `%s` not found".formatted(id)));

        accountType.setAccountType(accountTypeDtoRequest.accountType());

        return accountTypeRepository.save(accountType);
    }

    public void delete(Integer id) {
        accountTypeRepository.findById(id).ifPresent(accountTypeRepository::delete);
    }
}
