package ru.pilot.controller;

import org.springframework.web.bind.annotation.*;
import ru.pilot.entity.Currency;
import ru.pilot.model.request.CurrencyDtoRequest;
import ru.pilot.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getList() {
        return currencyService.getList();
    }

    @GetMapping("/{id}")
    public Currency getOne(@PathVariable Integer id) {
        return currencyService.getOne(id);
    }

    @GetMapping("/ids")
    public List<Currency> getMany(@RequestParam List<Integer> ids) {
        return currencyService.getMany(ids);
    }

    @PostMapping
    public Currency create(@RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return currencyService.create(currencyDtoRequest);
    }

    @PatchMapping("/{id}")
    public Currency patch(@PathVariable Integer id, @RequestBody CurrencyDtoRequest currencyDtoRequest)  {
        return currencyService.patch(id, currencyDtoRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        currencyService.delete(id);
    }
}
