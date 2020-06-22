package com.github.gauravgosavi.networthtracker.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class AssetsResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String chequingBalance ;
    private String savingsForTaxes ;
    private String rainyDayFund ;
    private String savingsForFun ;
    private String savingsForTravel ;
    private String savingsForPersonalDevelopment ;
    private String investment1 ;
    private String investment2 ;
    private String investment3 ;
    private String investment4 ;
    private String investment5 ;
    private String longTermAssets ;
    private String primaryHome ;
    private String secondHome ;
    private String others ;
}
