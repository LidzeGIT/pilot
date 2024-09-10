package ru.pilot.controller.account;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.AccountTypeDtoRequest;
import ru.pilot.service.IAccountClient;

import java.util.List;

@Tag(name = "AccountTypeController", description = "AccountTypeController")
@RestController
@RequestMapping("/account-service")
public class AccountTypeController {

    @Autowired
    private IAccountClient iAccountClient;

    @GetMapping("/account_types")
    public Object getListAccountType() {
        return iAccountClient.getListAccountType();
    }

    @GetMapping("/account_types/{id}")
    public Object getOneAccountType(@PathVariable Integer id) {
        return iAccountClient.getOneAccountType(id);
    }

    @GetMapping("/account_types/ids")
    public Object getManyAccountType(@RequestParam List<Integer> ids) {
        return iAccountClient.getManyAccountType(ids);
    }

    @PostMapping("/account_types")
    public Object createAccountType(@RequestBody AccountTypeDtoRequest accountType) {
        return iAccountClient.createAccountType(accountType);
    }

    @PatchMapping("/account_types/{id}")
    public Object patchAccountType(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType) {
        return iAccountClient.patchAccountType(id, accountType);
    }

    @DeleteMapping("/account_types/{id}")
    public void deleteAccountType(@PathVariable Integer id) {
        iAccountClient.deleteAccountType(id);
    }
}
