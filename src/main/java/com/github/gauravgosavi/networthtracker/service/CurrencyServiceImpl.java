package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.request.CurrenncyDto;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.SetUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public Set<CurrenncyDto> getAll() {
        Set<Currency> currencies = Sets.newHashSet(Currency.values());
        return transform(currencies);
    }

    /**
     * Converts the enum currency to a DTO fit for the UI to read.
     */
    private Set<CurrenncyDto> transform(Set<Currency> currencies) {
        return SetUtils.emptyIfNull(currencies)
                .stream()
                .map(currency -> {
                    return new CurrenncyDto(currency.getCurrencyCode());
                })
                .collect(Collectors.toSet());
    }
}
