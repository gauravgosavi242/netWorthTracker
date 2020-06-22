package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.response.NetWorthCurrencyConversionDto;
import com.github.gauravgosavi.networthtracker.dto.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.response.NetWorthResponseDto;

public interface NetworthCalculatorService {
    NetWorthResponseDto calculate(NetWorthRequestDto requestDto);

    NetWorthCurrencyConversionDto calculateWithCurrency(NetWorthRequestDto requestDto, String fromCurrency);
}
