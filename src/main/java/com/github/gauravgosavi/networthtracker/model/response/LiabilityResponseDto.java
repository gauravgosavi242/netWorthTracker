package com.github.gauravgosavi.networthtracker.model.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.gauravgosavi.networthtracker.Utils;
import com.github.gauravgosavi.networthtracker.model.request.LiabilityDto;
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
public class LiabilityResponseDto {
    private Integer id;
    private String name;
    private String value = BigDecimal.ZERO.toString();

    public LiabilityResponseDto(LiabilityDto liabilityDto, String toCurrency) {
        this.id=liabilityDto.getId();
        this.name=liabilityDto.getName();
        this.value= Utils.getFormattedCurrency(toCurrency, liabilityDto.getValue());

    }
}
