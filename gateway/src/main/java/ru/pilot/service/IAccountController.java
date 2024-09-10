package ru.pilot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.AccountTypeDtoRequest;
import ru.pilot.request.account.CreateAccountDtoRequest;
import ru.pilot.request.account.CurrencyDtoRequest;
import ru.pilot.request.account.UpdateAccountDtoRequest;

import java.util.List;

@FeignClient("account-client")
public interface IAccountController {
    @GetMapping("/api/v1/accounts/{accountId}")
    Object getAccounts(@PathVariable("accountId") Integer accountId);
    @GetMapping("/api/v1/accounts")
    Object getAccounts();
    @PutMapping("/api/v1/accounts/{accountId}")
    Object updateAccount(@RequestBody UpdateAccountDtoRequest changeAccountDtoRequest, @PathVariable("accountId") Integer accountId);
    @DeleteMapping("/api/v1/accounts/{accountId}")
    void deleteAccount(@PathVariable("accountId") Integer accountId);
    @PostMapping("/api/v1/accounts")
    Object createAccounts(@RequestBody CreateAccountDtoRequest createAccountDto);

    @GetMapping("/api/v1/account_types")
    Object getListAccountType() ;
    @GetMapping("/api/v1/account_types/{id}")
    Object getOneAccountType(@PathVariable Integer id);
    @GetMapping("/api/v1/account_types/ids")
    Object getManyAccountType(@RequestParam List<Integer> ids);
    @PostMapping("/api/v1/account_types")
    Object createAccountType(@RequestBody AccountTypeDtoRequest accountType);
    @PatchMapping("/api/v1/account_types/{id}")
    Object patchAccountType(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType);
    @DeleteMapping("/api/v1/account_types/{id}")
    void deleteAccountType(@PathVariable Integer id);

    @GetMapping("/api/v1/currency")
    Object getListCurrency() ;
    @GetMapping("/api/v1/currency/{id}")
    Object getOneCurrency(@PathVariable Integer id);
    @GetMapping("/api/v1/currency/ids")
    Object getManyCurrency(@RequestParam List<Integer> ids);
    @PostMapping("/api/v1/currency")
    Object createCurrency(@RequestBody CurrencyDtoRequest currencyDtoRequest);
    @PatchMapping("/api/v1/currency/{id}")
    Object patchCurrency(@PathVariable Integer id, @RequestBody CurrencyDtoRequest currencyDtoRequest);
    @DeleteMapping("/api/v1/currency/{id}")
    void deleteCurrency(@PathVariable Integer id);
}