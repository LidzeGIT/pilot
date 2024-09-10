package ru.pilot.controller;

import org.springframework.web.bind.annotation.*;
import ru.pilot.entity.AccountType;
import ru.pilot.model.request.AccountTypeDtoRequest;
import ru.pilot.service.AccountTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account_types")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    @GetMapping
    public List<AccountType> getList() {
        return accountTypeService.getList();
    }

    @GetMapping("/{id}")
    public AccountType getOne(@PathVariable Integer id) {
        return accountTypeService.getOne(id);
    }

    @GetMapping("/ids")
    public List<AccountType> getMany(@RequestParam List<Integer> ids) {
        return accountTypeService.getMany(ids);
    }

    @PostMapping
    public AccountType create(@RequestBody AccountTypeDtoRequest accountType) {
        return accountTypeService.create(accountType);
    }

    @PatchMapping("/{id}")
    public AccountType patch(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType) {
        return accountTypeService.patch(id, accountType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        accountTypeService.delete(id);
    }
}
