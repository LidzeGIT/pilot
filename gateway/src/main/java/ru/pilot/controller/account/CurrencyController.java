package ru.pilot.controller.account;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pilot.request.account.CurrencyDtoRequest;
import ru.pilot.service.IAccountController;

import java.util.List;

@Tag(name = "CurrencyController", description = "CurrencyController")
@RestController
public class CurrencyController {

    @Autowired
    private IAccountController iAccountController;

    @GetMapping("/currency")
    public Object getListCurrency() {
        return iAccountController.getListCurrency();
    }

    @GetMapping("/currency/{id}")
    public Object getOneCurrency(@PathVariable Integer id) {
        return iAccountController.getOneCurrency(id);
    }

    @GetMapping("/currency/ids")
    public Object getManyCurrency(@RequestParam List<Integer> ids) {
        return iAccountController.getManyCurrency(ids);
    }

    @PostMapping("/currency")
    public Object createCurrency(@RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return iAccountController.createCurrency(currencyDtoRequest);
    }

    @PatchMapping("/currency/{id}")
    public Object patchCurrency(@PathVariable Integer id, @RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return iAccountController.patchCurrency(id, currencyDtoRequest);
    }

    @DeleteMapping("/currency/{id}")
    public void deleteCurrency(@PathVariable Integer id) {
        iAccountController.deleteCurrency(id);
    }
}
