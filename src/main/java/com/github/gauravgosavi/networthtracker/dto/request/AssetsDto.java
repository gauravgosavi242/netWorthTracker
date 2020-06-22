package com.github.gauravgosavi.networthtracker.dto.request;

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
public class AssetsDto {
    private BigDecimal chequingBalance = BigDecimal.ZERO;
    private BigDecimal savingsForTaxes = BigDecimal.ZERO;
    private BigDecimal rainyDayFund = BigDecimal.ZERO;
    private BigDecimal savingsForFun = BigDecimal.ZERO;
    private BigDecimal savingsForTravel = BigDecimal.ZERO;
    private BigDecimal savingsForPersonalDevelopment = BigDecimal.ZERO;
    private BigDecimal investment1 = BigDecimal.ZERO;
    private BigDecimal investment2 = BigDecimal.ZERO;
    private BigDecimal investment3 = BigDecimal.ZERO;
    private BigDecimal investment4 = BigDecimal.ZERO;
    private BigDecimal investment5 = BigDecimal.ZERO;
    private BigDecimal longTermAssets = BigDecimal.ZERO;
    private BigDecimal primaryHome = BigDecimal.ZERO;
    private BigDecimal secondHome = BigDecimal.ZERO;
    private BigDecimal others = BigDecimal.ZERO;
}
