package com.github.gauravgosavi.networthtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gauravgosavi.networthtracker.dto.AssetsDto;
import com.github.gauravgosavi.networthtracker.dto.LiabilitiesDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.NetWorthCalculatorServiceImpl;
import com.github.gauravgosavi.networthtracker.service.NetworthCalculatorService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

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

        NetWorthRequestDto requestDto = new NetWorthRequestDto();

        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setChequingBalance(BigDecimal.TEN);
        assetsDto.setChequingBalance(BigDecimal.TEN);

        LiabilitiesDto liabilitiesDto = new LiabilitiesDto();
        liabilitiesDto.setCarLoan(BigDecimal.TEN);
        liabilitiesDto.setCreditCard1(BigDecimal.TEN);
        liabilitiesDto.setLineOfCredit(BigDecimal.ONE);

        requestDto.setLiabilitiesDto(liabilitiesDto);
        requestDto.setAssetsDto(assetsDto);

        String string = new ObjectMapper().writeValueAsString(netWorthResponseDto);

        System.out.println(string);

    }
}