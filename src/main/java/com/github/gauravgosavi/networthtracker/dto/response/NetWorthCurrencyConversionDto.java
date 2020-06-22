package com.github.gauravgosavi.networthtracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class NetWorthCurrencyConversionDto {
    private AssetsResponseDto assetsDto;
    private LiabilitiesResponseDto liabilitiesDto;

    private String netWorthAmount;

    private String currencyCode;
}
