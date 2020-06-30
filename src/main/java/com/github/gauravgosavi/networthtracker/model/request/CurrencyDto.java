package com.github.gauravgosavi.networthtracker.model.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonAutoDetect
@AllArgsConstructor
@EqualsAndHashCode
public class CurrencyDto implements Serializable, Comparable<Integer> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String currencyCode;


    @Override
    public int compareTo(Integer o) {
        Assert.notNull(o, "incoming ID cannot be null");
        return o.compareTo(id);
    }

    public String toString() {
        return "CurrencyDto(id=" + this.getId() + ", currencyCode=" + this.getCurrencyCode() + ")";
    }
}
