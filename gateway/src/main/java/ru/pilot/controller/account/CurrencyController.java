package ru.pilot.controller.account;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.CurrencyDtoRequest;
import ru.pilot.service.IAccountClient;

import java.util.List;

@Tag(name = "CurrencyController", description = "CurrencyController")
@RestController
public class CurrencyController {

    @Autowired
    private IAccountClient iAccountClient;

    @GetMapping("/currency")
    public Object getListCurrency() {
        return iAccountClient.getListCurrency();
    }

    @GetMapping("/currency/{id}")
    public Object getOneCurrency(@PathVariable Integer id) {
        return iAccountClient.getOneCurrency(id);
    }

    @GetMapping("/currency/ids")
    public Object getManyCurrency(@RequestParam List<Integer> ids) {
        return iAccountClient.getManyCurrency(ids);
    }

    @PostMapping("/currency")
    public Object createCurrency(@RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return iAccountClient.createCurrency(currencyDtoRequest);
    }

    @PatchMapping("/currency/{id}")
    public Object patchCurrency(@PathVariable Integer id, @RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return iAccountClient.patchCurrency(id, currencyDtoRequest);
    }

    @DeleteMapping("/currency/{id}")
    public void deleteCurrency(@PathVariable Integer id) {
        iAccountClient.deleteCurrency(id);
    }
}
