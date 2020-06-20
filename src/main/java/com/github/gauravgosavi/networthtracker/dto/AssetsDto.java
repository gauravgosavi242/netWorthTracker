package com.github.gauravgosavi.networthtracker.dto;

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
    private BigDecimal chequingBalance;
    private BigDecimal savingsForTaxes;
    private BigDecimal rainyDayFund;
    private BigDecimal savingsForFun;
    private BigDecimal savingsForTravel;
    private BigDecimal savingsForPersonalDevelopment;
    private BigDecimal investment1;
    private BigDecimal investment2;
    private BigDecimal investment3;
    private BigDecimal investment4;
    private BigDecimal investment5;
    private BigDecimal longTermAssets;
    private BigDecimal primaryHome;
    private BigDecimal secondHome;
    private BigDecimal others;
}
