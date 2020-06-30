package com.github.gauravgosavi.networthtracker.controller;

import com.github.gauravgosavi.networthtracker.model.request.CurrencyDto;
import com.github.gauravgosavi.networthtracker.model.response.CurrencyResponseDto;
import com.github.gauravgosavi.networthtracker.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(method = GET, value = "/all")
    public CurrencyResponseDto getAllCurrencies(){
        log.info("Received currencies call");
        Collection<CurrencyDto> result = currencyService.getAll();
        log.info(Arrays.toString(result.toArray()));
        return new CurrencyResponseDto(result);
    }
}
