package com.github.gauravgosavi.networthtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gauravgosavi.networthtracker.dto.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.NetWorthCalculatorServiceImpl;
import com.github.gauravgosavi.networthtracker.service.NetworthCalculatorService;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;

public class NetworthControllerTest {

    public static final String BASE_DIR = "src/test/resources/";
    public static final String REQUEST_DTO = "netWorthRequestDto.json";
    public static final String RESPONSE_DTO = "netWorthResponseDto.json";

    private NetworthCalculatorService service = new NetWorthCalculatorServiceImpl();
    private NetworthController target = new NetworthController(service);

    @Test
    @SneakyThrows
    public void calculate() {
        File requestFile = new File(BASE_DIR + REQUEST_DTO);
        NetWorthRequestDto netWorthRequestDto = new ObjectMapper().readValue(requestFile, NetWorthRequestDto.class);

        NetWorthResponseDto netWorthResponseDto = target.calculate(netWorthRequestDto);

        String calculatedResponse = new ObjectMapper().writeValueAsString(netWorthResponseDto);

        File responseFile = new File(BASE_DIR + RESPONSE_DTO);
        NetWorthResponseDto responseDto = new ObjectMapper().readValue(responseFile, NetWorthResponseDto.class);

        String response = new ObjectMapper().writeValueAsString(responseDto);

        Assert.assertEquals(calculatedResponse, response);


    }
}