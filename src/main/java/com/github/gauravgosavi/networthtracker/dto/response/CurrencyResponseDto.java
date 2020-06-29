package com.github.gauravgosavi.networthtracker.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.gauravgosavi.networthtracker.dto.request.CurrencyDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@JsonAutoDetect
@NoArgsConstructor
public class CurrencyResponseDto {
    public CurrencyResponseDto(Collection<CurrencyDto> currencyDtos) {
        this.currencyDtos = currencyDtos;
    }

    Collection<CurrencyDto> currencyDtos;
}
