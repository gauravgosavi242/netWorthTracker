package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthResponseDto;

public interface NetworthCalculatorService {
    NetWorthResponseDto calculate(NetWorthRequestDto requestDto);
}
