package com.github.gauravgosavi.networthtracker.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@EqualsAndHashCode
public class NetWorthResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String networthAmount;
    private String currencyCode;
}
