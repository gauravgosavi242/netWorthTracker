package com.github.gauravgosavi.networthtracker.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect
public class NetWorthRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private AssetsDto assetsDto;
    private LiabilitiesDto liabilitiesDto;

    private AssetRequestDto assetRequestDto;
    private LiabilityRequestDto liabilityRequestDto;

    private String currencyCode;

}
