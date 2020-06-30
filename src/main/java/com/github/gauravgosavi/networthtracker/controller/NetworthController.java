package com.github.gauravgosavi.networthtracker.controller;

import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthResponseDto;
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

//    @RequestMapping(method = PUT, value = "/calculate/{currency}")
//    public



    @RequestMapping(method = PUT, value = "/{from-currency}/currency/{to-currency}/to/v2")
    public NetWorthResponseDto calculateWithCurrencyV2(
            @PathVariable("from-currency") String fromCurrency,
            @PathVariable("to-currency") String toCurrency,

            @RequestBody NetWorthRequestDto requestDto){
        return networthCalculatorService.convertToCurrency(requestDto, fromCurrency, toCurrency);
    }
}
