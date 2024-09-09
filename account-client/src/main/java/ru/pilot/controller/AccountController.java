package ru.pilot.controller;


import org.springframework.web.bind.annotation.*;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;

import java.util.List;


public interface AccountController {

        @PostMapping()
        CreateAccountDtoResponse createAccounts(@RequestBody CreateAccountDtoRequest createAccountDto);
        @GetMapping("/{accountId}")
        CreateAccountDtoResponse getAccounts(@PathVariable("accountId") Integer accountId);
        @GetMapping()
        List<CreateAccountDtoResponse> getAccounts();
        @PutMapping("/{accountId}")
        CreateAccountDtoResponse updateAccount(@RequestBody UpdateAccountDtoRequest changeAccountDtoRequest,
                                               @PathVariable("accountId") Integer accountId);
        @DeleteMapping("/{accountId}")
        void deleteAccount(@PathVariable("accountId") Integer accountId);

}
