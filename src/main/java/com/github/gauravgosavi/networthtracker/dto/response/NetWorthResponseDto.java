package com.github.gauravgosavi.networthtracker.dto.response;

import com.github.gauravgosavi.networthtracker.dto.request.AssetDto;
import com.github.gauravgosavi.networthtracker.dto.request.LiabilityDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NetWorthResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AssetDto> assetDtos;
    private List<LiabilityDto> liabilityDto;


    private String networthAmount;
    private String currencyCode;
}
