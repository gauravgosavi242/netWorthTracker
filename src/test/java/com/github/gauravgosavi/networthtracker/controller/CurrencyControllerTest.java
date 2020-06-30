package com.github.gauravgosavi.networthtracker.controller;

import com.github.gauravgosavi.networthtracker.model.request.CurrencyDto;
import com.github.gauravgosavi.networthtracker.model.response.CurrencyResponseDto;
import com.github.gauravgosavi.networthtracker.service.CurrencyServiceImpl;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyControllerTest {

    private CurrencyController target = new CurrencyController(new CurrencyServiceImpl());

    @Test
    public void testCurrencyGetter(){
        CurrencyResponseDto allCurrencies = target.getAllCurrencies();
        Assert.assertEquals(allCurrencies.getCurrencyDtos().size(), Currency.values().length);

        List<Currency> currencies = (Arrays.asList(Currency.values()));
        List<String> currencyCodesSorted = currencies.stream().map(Currency::getCurrencyCode).sorted().collect(Collectors.toList());

        List<String> actualCurrencies = allCurrencies.getCurrencyDtos().stream().map(CurrencyDto::getCurrencyCode)
                .sorted()
                .collect(Collectors.toList());

        Assert.assertTrue(currencyCodesSorted.containsAll(actualCurrencies));
    }

}
