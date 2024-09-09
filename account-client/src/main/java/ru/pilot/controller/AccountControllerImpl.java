package ru.pilot.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pilot.model.request.CreateAccountDtoRequest;
import ru.pilot.model.request.UpdateAccountDtoRequest;
import ru.pilot.model.response.CreateAccountDtoResponse;
import ru.pilot.service.AccountService;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/accounts")
public class AccountControllerImpl implements AccountController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private AccountService accountService;

    @Override
    public CreateAccountDtoResponse createAccounts(CreateAccountDtoRequest createAccountDto) {
        return accountService.createAccounts(createAccountDto);
    }

    @Override
    public List<CreateAccountDtoResponse> getAccounts() {
        return accountService.getAccounts();
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountService.deleteAccount(accountId);
    }

    @Override
    public CreateAccountDtoResponse updateAccount(UpdateAccountDtoRequest changeAccountDtoRequest, Integer accountId) {
        return accountService.updateAccount(changeAccountDtoRequest, accountId);
    }

    @Override
    public CreateAccountDtoResponse getAccounts(Integer accountId) {
        return accountService.getAccounts(accountId);
    }
}
