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
public class LiabilitiesResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String creditCard1 ;
    private String creditCard2 ;
    private String other ;
    private String longTermDebt ;
    private String mortgage1 ;
    private String mortgage2 ;
    private String lineOfCredit ;
    private String investmentLoan ;
    private String studentLoan ;
    private String carLoan ;
}
