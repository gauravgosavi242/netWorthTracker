package com.github.gauravgosavi.networthtracker.controller;

import com.github.gauravgosavi.networthtracker.dto.request.CurrenncyDto;
import com.github.gauravgosavi.networthtracker.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(method = GET, value = "/all")
    public Set<CurrenncyDto> getAllCurrencies(){
        return currencyService.getAll();
    }
}
