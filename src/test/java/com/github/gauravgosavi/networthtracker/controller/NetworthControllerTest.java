package com.github.gauravgosavi.networthtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthInfoDto;
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
    public static final String RESPONSE_DTO_TO_CAD = "netWorthResponseDtoWithCAD.json";
    public static final String REQUEST_FOR_CALC_JSON = "networthRequestDtoForCalculations.json";

    private NetworthCalculatorService service = new NetWorthCalculatorServiceImpl();
    private NetworthController target = new NetworthController(service);

    @Test
    @SneakyThrows
    public void convertUSDtoUSD() {
        File requestFile = new File(BASE_DIR + RESPONSE_DTO);
        NetWorthInfoDto netWorthRequestDto = new ObjectMapper().readValue(requestFile, NetWorthInfoDto.class);

        NetWorthInfoDto netWorthInfoDto = target.calculateWithCurrencyV2("USD","USD", netWorthRequestDto);

        String calculatedResponse = new ObjectMapper().writeValueAsString(netWorthInfoDto);

        File responseFile = new File(BASE_DIR + RESPONSE_DTO);
        NetWorthInfoDto responseDto = new ObjectMapper().readValue(responseFile, NetWorthInfoDto.class);

        String response = new ObjectMapper().writeValueAsString(responseDto);

        Assert.assertEquals(calculatedResponse, response);


    }

    @Test
    @SneakyThrows
    public void convertUSDtoCAD() {
        File requestFile = new File(BASE_DIR + REQUEST_DTO);
        NetWorthInfoDto netWorthRequestDto = new ObjectMapper().readValue(requestFile, NetWorthInfoDto.class);

        NetWorthInfoDto netWorthInfoDto = target.calculateWithCurrencyV2("USD","CAD", netWorthRequestDto);

        String calculatedResponse = new ObjectMapper().writeValueAsString(netWorthInfoDto);

        File responseFile = new File(BASE_DIR + RESPONSE_DTO_TO_CAD);
        NetWorthInfoDto responseDto = new ObjectMapper().readValue(responseFile, NetWorthInfoDto.class);

        String response = new ObjectMapper().writeValueAsString(responseDto);

        Assert.assertEquals(calculatedResponse, response);


    }

    @Test
    @SneakyThrows
    public void testCalcuations(){
        File requestFile = new File(BASE_DIR + REQUEST_FOR_CALC_JSON);
        NetWorthRequestDto netWorthRequestDto = new ObjectMapper().readValue(requestFile, NetWorthRequestDto.class);

        NetWorthInfoDto netWorthInfoDto = target.calculate("USD", netWorthRequestDto);

        String calculatedResponse = new ObjectMapper().writeValueAsString(netWorthInfoDto);
        File responseFile = new File(BASE_DIR + RESPONSE_DTO);
        NetWorthInfoDto responseDto = new ObjectMapper().readValue(responseFile, NetWorthInfoDto.class);

        String response = new ObjectMapper().writeValueAsString(responseDto);

        Assert.assertEquals(calculatedResponse, response);
    }
}