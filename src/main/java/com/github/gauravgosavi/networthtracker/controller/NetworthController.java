package com.github.gauravgosavi.networthtracker.controller;

import com.github.gauravgosavi.networthtracker.dto.response.NetWorthCurrencyConversionDto;
import com.github.gauravgosavi.networthtracker.dto.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.response.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.NetworthCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@RestController
@RequestMapping(value = "/calculate")
public class NetworthController {

    private final NetworthCalculatorService networthCalculatorService;

    @Autowired
    public NetworthController(@Qualifier(value = "networthCalculatorService") NetworthCalculatorService networthCalculatorService) {
        this.networthCalculatorService = networthCalculatorService;
    }

    @RequestMapping(method = PUT, value = "/")
    public NetWorthResponseDto calculate(@RequestBody NetWorthRequestDto requestDto){
        return networthCalculatorService.calculate(requestDto);

    }

    @RequestMapping(method = PUT, value = "/{from-currency}/currency")
    public NetWorthCurrencyConversionDto calculateWithCurrency(
            @PathVariable("from-currency") String fromCurrency,
            @RequestBody NetWorthRequestDto requestDto){
        return networthCalculatorService.calculateWithCurrency(requestDto, fromCurrency);
    }
}
