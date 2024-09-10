package ru.pilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;
import ru.pilot.service.AccountService;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public CreateAccountDtoResponse createAccounts(@RequestBody CreateAccountDtoRequest createAccountDto) {
        return accountService.createAccounts(createAccountDto);
    }

    @GetMapping()
    public List<CreateAccountDtoResponse> getAccounts() {
        return accountService.getAccounts();
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable("accountId") Integer accountId) {
        accountService.deleteAccount(accountId);
    }

    @PutMapping("/{accountId}")
    public CreateAccountDtoResponse updateAccount(@RequestBody UpdateAccountDtoRequest changeAccountDtoRequest,
                                                  @PathVariable("accountId") Integer accountId) {
        return accountService.updateAccount(changeAccountDtoRequest, accountId);
    }

    @GetMapping("/{accountId}")
    public CreateAccountDtoResponse getAccounts(@PathVariable("accountId") Integer accountId) {
        return accountService.getAccounts(accountId);
    }
}
