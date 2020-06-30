package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthResponseDto;

public interface NetworthCalculatorService {

    NetWorthResponseDto convertToCurrency(NetWorthRequestDto requestDto, String fromCurrency, String toCurrency);
}
