package ru.pilot.controller;

import org.springframework.web.bind.annotation.*;
import ru.pilot.entity.AccountType;
import ru.pilot.model.request.AccountTypeDtoRequest;

import java.io.IOException;
import java.util.List;

public interface AccountTypeController {
    @GetMapping
    List<AccountType> getList() ;
    @GetMapping("/{id}")
    AccountType getOne(@PathVariable Integer id);
    @GetMapping("/ids")
    List<AccountType> getMany(@RequestParam List<Integer> ids);
    @PostMapping
    AccountType create(@RequestBody AccountTypeDtoRequest accountType);
    @PatchMapping("/{id}")
    AccountType patch(@PathVariable Integer id, @RequestBody AccountTypeDtoRequest accountType) throws IOException;
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id);
}
