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
public class NetWorthResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal networthAmount;
    private String currencyCode;
}
