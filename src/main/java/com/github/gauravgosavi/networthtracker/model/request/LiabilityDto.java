package com.github.gauravgosavi.networthtracker.model.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
public class LiabilityDto {
    private Integer id;
    private String name;
    private BigDecimal value = BigDecimal.ZERO;
}
