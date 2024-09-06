package ru.pilot.controller;


import org.springframework.web.bind.annotation.*;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;

import java.util.List;


public interface AccountController {

        @PostMapping("/accounts")
        CreateAccountDtoResponse createAccounts(@RequestBody CreateAccountDtoRequest createAccountDto);
        @GetMapping("/accounts/{accountId}")
        CreateAccountDtoResponse getAccounts(@PathVariable("accountId") Integer accountId);
        @GetMapping("/accounts")
        List<CreateAccountDtoResponse> getAccounts();
        @PutMapping("/accounts/{accountId}")
        CreateAccountDtoResponse updateAccount(@RequestBody UpdateAccountDtoRequest changeAccountDtoRequest,
                                               @PathVariable("accountId") long accountId);
        @DeleteMapping("/accounts/{accountId}")
        void deleteAccount(@PathVariable("accountId") Integer accountId);

}
