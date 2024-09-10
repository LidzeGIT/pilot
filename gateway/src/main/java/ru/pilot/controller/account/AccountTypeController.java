package ru.pilot.controller.account;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.AccountTypeDtoRequest;
import ru.pilot.request.account.CurrencyDtoRequest;
import ru.pilot.service.IAccountController;

import java.util.List;

@Tag(name = "AccountTypeController", description = "AccountTypeController")
@RestController
public class AccountTypeController {

    @Autowired
    private IAccountController iAccountController;

    @GetMapping("/account_types")
    public Object getListAccountType() {
        return iAccountController.getListAccountType();
    }

    @GetMapping("/account_types/{id}")
    public Object getOneAccountType(@PathVariable Integer id) {
        return iAccountController.getOneAccountType(id);
    }

    @GetMapping("/account_types/ids")
    public Object getManyAccountType(@RequestParam List<Integer> ids) {
        return iAccountController.getManyAccountType(ids);
    }

    @PostMapping("/account_types")
    public Object createAccountType(@RequestBody AccountTypeDtoRequest accountType) {
        return iAccountController.createAccountType(accountType);
    }

    @PatchMapping("/account_types/{id}")
    public Object patchAccountType(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType) {
        return iAccountController.patchAccountType(id, accountType);
    }

    @DeleteMapping("/account_types/{id}")
    public void deleteAccountType(@PathVariable Integer id) {
        iAccountController.deleteAccountType(id);
    }
}
