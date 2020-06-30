package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.model.request.CurrencyDto;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.SetUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public Collection<CurrencyDto> getAll() {
        Set<Currency> currencies = Sets.newHashSet(Currency.values());
        return transform(currencies);
    }

    /**
     * Converts the enum currency to a DTO fit for the UI to read.
     */
    private Set<CurrencyDto> transform(Set<Currency> currencies) {
        return SetUtils.emptyIfNull(currencies)
                .stream()
                .map(currency -> new CurrencyDto(currency.getID(), currency.getCurrencyCode()))
                .sorted(Comparator.comparing(CurrencyDto::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
