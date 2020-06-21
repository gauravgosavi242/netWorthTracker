package com.github.gauravgosavi.networthtracker.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class LiabilitiesDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal creditCard1 = BigDecimal.ZERO;
    private BigDecimal creditCard2 = BigDecimal.ZERO;
    private BigDecimal other = BigDecimal.ZERO;
    private BigDecimal longTermDebt = BigDecimal.ZERO;
    private BigDecimal mortgage1 = BigDecimal.ZERO;
    private BigDecimal mortgage2 = BigDecimal.ZERO;
    private BigDecimal lineOfCredit = BigDecimal.ZERO;
    private BigDecimal investmentLoan = BigDecimal.ZERO;
    private BigDecimal studentLoan = BigDecimal.ZERO;
    private BigDecimal carLoan = BigDecimal.ZERO;

}
