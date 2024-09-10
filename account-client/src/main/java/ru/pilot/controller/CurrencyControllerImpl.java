package ru.pilot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pilot.entity.Currency;
import ru.pilot.model.request.CurrencyDtoRequest;
import ru.pilot.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyControllerImpl implements CurrencyController{

    private final CurrencyService currencyService;

    public CurrencyControllerImpl(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public List<Currency> getList() {
        return currencyService.getList();
    }

    @Override
    public Currency getOne(Integer id) {
        return currencyService.getOne(id);
    }

    @Override
    public List<Currency> getMany(List<Integer> ids) {
        return currencyService.getMany(ids);
    }

    @Override
    public Currency create(CurrencyDtoRequest currencyDtoRequest) {
        return currencyService.create(currencyDtoRequest);
    }

    @Override
    public Currency patch(Integer id, CurrencyDtoRequest currencyDtoRequest)  {
        return currencyService.patch(id, currencyDtoRequest);
    }

    @Override
    public void delete(Integer id) {
        currencyService.delete(id);
    }
}
