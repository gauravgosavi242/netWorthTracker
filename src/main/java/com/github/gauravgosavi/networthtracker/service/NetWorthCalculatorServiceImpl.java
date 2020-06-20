package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("networthCalculatorService")
public class NetWorthCalculatorServiceImpl implements NetworthCalculatorService {

    @Override
    public NetWorthResponseDto calculate(NetWorthRequestDto requestDto){
        log.info("Received request");
        return null;
    }
}
