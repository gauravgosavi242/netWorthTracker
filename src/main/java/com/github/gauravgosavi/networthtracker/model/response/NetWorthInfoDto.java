package com.github.gauravgosavi.networthtracker.model.response;

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
public class NetWorthInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AssetResponseDto> assetDtos;
    private List<LiabilityResponseDto> liabilityDto;

    private String netAssets;
    private String netLiabilites;

    private String networthAmount;

    private String currencyCode;
}
