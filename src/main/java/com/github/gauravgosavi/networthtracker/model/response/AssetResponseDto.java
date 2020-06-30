package com.github.gauravgosavi.networthtracker.model.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.gauravgosavi.networthtracker.Utils;
import com.github.gauravgosavi.networthtracker.model.request.AssetDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonAutoDetect
public class AssetResponseDto {
    private Integer id;
    private String name;
    private String value=BigDecimal.ZERO.toString();

    public AssetResponseDto(AssetDto assetDto, String toCurrency) {
        this.id=assetDto.getId();
        this.name=assetDto.getName();
        this.value= Utils.getFormattedCurrency(toCurrency, assetDto.getValue());;

    }
}
