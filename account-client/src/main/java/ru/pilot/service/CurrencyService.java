package ru.pilot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.pilot.entity.Currency;
import ru.pilot.model.request.CurrencyDtoRequest;
import ru.pilot.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getList() {
        return currencyRepository.findAll();
    }

    public Currency getOne(Integer id) {
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        return currencyOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Currency with id `%s` not found".formatted(id)));
    }

    public List<Currency> getMany(List<Integer> ids) {
        return currencyRepository.findAllById(ids);
    }

    public Currency create(CurrencyDtoRequest currencyDtoRequest) {
        Currency type = new Currency(currencyDtoRequest.currency());
        Optional<Currency> currency = currencyRepository.findByCurrencyCode(currencyDtoRequest.currency());
        return currency.orElseGet(() -> currencyRepository.save(type));
    }

    public Currency patch(Integer id, CurrencyDtoRequest currencyDtoRequest) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Currency with id `%s` not found".formatted(id)));

        currency.setCurrencyCode(currencyDtoRequest.currency());

        return currencyRepository.save(currency);
    }

    public void delete(Integer id) {
        currencyRepository.findById(id).ifPresent(currencyRepository::delete);
    }

}
