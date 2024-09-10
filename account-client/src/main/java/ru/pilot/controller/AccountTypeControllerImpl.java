package ru.pilot.controller;

import org.springframework.web.bind.annotation.*;
import ru.pilot.entity.AccountType;
import ru.pilot.model.request.AccountTypeDtoRequest;
import ru.pilot.service.AccountTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account_types")
public class AccountTypeControllerImpl implements AccountTypeController {

    private final AccountTypeService accountTypeService;

    public AccountTypeControllerImpl(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    @Override
    public List<AccountType> getList() {
        return accountTypeService.getList();
    }

    @Override
    public AccountType getOne(@PathVariable Integer id) {
        return accountTypeService.getOne(id);
    }

    @Override
    public List<AccountType> getMany(@RequestParam List<Integer> ids) {
        return accountTypeService.getMany(ids);
    }

    @Override
    public AccountType create(@RequestBody AccountTypeDtoRequest accountType) {
        return accountTypeService.create(accountType);
    }

    @Override
    public AccountType patch(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType) {
        return accountTypeService.patch(id, accountType);
    }

    @Override
    public void delete(@PathVariable Integer id) {
        accountTypeService.delete(id);
    }
}
