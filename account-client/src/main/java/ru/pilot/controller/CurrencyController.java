package ru.pilot.controller;

import org.springframework.web.bind.annotation.*;
import ru.pilot.entity.Currency;
import ru.pilot.model.request.CurrencyDtoRequest;

import java.io.IOException;
import java.util.List;

public interface CurrencyController {
    @GetMapping
    List<Currency> getList() ;
    @GetMapping("/{id}")
    Currency getOne(@PathVariable Integer id);
    @GetMapping("/ids")
    List<Currency> getMany(@RequestParam List<Integer> ids);
    @PostMapping
    Currency create(@RequestBody CurrencyDtoRequest currencyDtoRequest);
    @PatchMapping("/{id}")
    Currency patch(@PathVariable Integer id, @RequestBody CurrencyDtoRequest currencyDtoRequest) throws IOException;
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id);
}
