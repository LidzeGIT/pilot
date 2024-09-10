package ru.pilot.controller.account;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.AccountTypeDtoRequest;
import ru.pilot.request.account.CreateAccountDtoRequest;
import ru.pilot.request.account.CurrencyDtoRequest;
import ru.pilot.request.account.UpdateAccountDtoRequest;
import ru.pilot.service.IAccountController;

import java.util.List;

@Tag(name = "AccountController", description = "AccountController")
@RestController
public class AccountController {

    @Autowired
    private IAccountController iAccountController;

    @GetMapping("/{accountId}")
    public Object getAccounts(@PathVariable("accountId") Integer a) {
        return iAccountController.getAccounts(a);
    }

    @GetMapping("/accounts")
    public Object getAccounts() {
        return iAccountController.getAccounts();
    }

    @PutMapping("/accounts/{accountId}")
    public Object updateAccount(@RequestBody UpdateAccountDtoRequest changeAccountDtoRequest, @PathVariable("accountId") Integer accountId) {
        return iAccountController.updateAccount(changeAccountDtoRequest, accountId);
    }

    @DeleteMapping("/accounts/{accountId}")
    public void deleteAccount(@PathVariable("accountId") Integer accountId) {
        iAccountController.deleteAccount(accountId);
    }

    @PostMapping("/accounts")
    public Object createAccounts(@RequestBody CreateAccountDtoRequest createAccountDto) {
        return iAccountController.createAccounts(createAccountDto);
    }
}
