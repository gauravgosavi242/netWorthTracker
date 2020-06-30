package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthInfoDto;

public interface NetworthCalculatorService {

    NetWorthInfoDto convertToCurrency(NetWorthInfoDto requestDto, String fromCurrency, String toCurrency);

    NetWorthInfoDto calculate(NetWorthRequestDto netWorthRequestDto, String currency);
}
