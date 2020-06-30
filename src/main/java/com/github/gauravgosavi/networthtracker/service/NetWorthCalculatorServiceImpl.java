package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.Utils;
import com.github.gauravgosavi.networthtracker.model.request.AssetDto;
import com.github.gauravgosavi.networthtracker.model.request.AssetRequestDto;
import com.github.gauravgosavi.networthtracker.model.request.LiabilityDto;
import com.github.gauravgosavi.networthtracker.model.request.LiabilityRequestDto;
import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.AssetResponseDto;
import com.github.gauravgosavi.networthtracker.model.response.LiabilityResponseDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.ListUtils.emptyIfNull;

@Slf4j
@Service("networthCalculatorService")
public class NetWorthCalculatorServiceImpl implements NetworthCalculatorService {

    private static final Currency DEFAULT_CURRENCY = Currency.USD; // Assuming default currency to be USD

    @Override
    public NetWorthResponseDto convertToCurrency(NetWorthRequestDto requestDto, String fromCurrency, String toCurrency) {
        AssetRequestDto assetRequestDto = requestDto.getAssetRequestDto();
        LiabilityRequestDto liabilityRequestDto = requestDto.getLiabilityRequestDto();

        currencyConvertIncomingRequests(assetRequestDto, liabilityRequestDto,
                Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(toCurrency));

        Optional<BigDecimal> assetValueOptional;
        assetValueOptional = emptyIfNull(assetRequestDto.getAssetDtos()).stream().map(AssetDto::getValue)
                .collect(Collectors.toList()).stream()
                .reduce(BigDecimal::add);

        BigDecimal assetValue = assetValueOptional.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.CEILING);
        log.info("Net assets {}", assetValue);

        Optional<BigDecimal> liabilityValueOptional = emptyIfNull(liabilityRequestDto.getLiabilityDto()).stream().map(LiabilityDto::getValue)
                .collect(Collectors.toList()).stream()
                .reduce(BigDecimal::add);

        BigDecimal liabilityValue = liabilityValueOptional.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.CEILING);

        log.info("Net Liability {}", liabilityValue);

        BigDecimal networth = assetValue.subtract(liabilityValue);

        log.info("Net Worth {}", networth);

        return new NetWorthResponseDto(
                getAssetResponseDtos(assetRequestDto.getAssetDtos(), toCurrency),
                getLiabilityResponseDtos(liabilityRequestDto.getLiabilityDto(), toCurrency),
                Utils.getFormattedCurrency(toCurrency, assetValue),
                Utils.getFormattedCurrency(toCurrency, liabilityValue),
                Utils.getFormattedCurrency(toCurrency, networth), toCurrency);
    }

    private List<AssetResponseDto> getAssetResponseDtos(List<AssetDto> assetDtos, String toCurrency) {
        return emptyIfNull(assetDtos).stream().map(assetDto -> new AssetResponseDto(assetDto, toCurrency)).collect(Collectors.toList());
    }

    private List<LiabilityResponseDto> getLiabilityResponseDtos(List<LiabilityDto> liabilityDtos, String toCurrency) {
        return emptyIfNull(liabilityDtos).stream().map(liabilityDto -> new LiabilityResponseDto(liabilityDto, toCurrency)).collect(Collectors.toList());
    }

    private void currencyConvertIncomingRequests(AssetRequestDto assetRequestDto, LiabilityRequestDto liabilityRequestDto, Currency fromCurrency, Currency toCurrency) {
        for (AssetDto assetDto : emptyIfNull(assetRequestDto.getAssetDtos())) {
            BigDecimal assetVal = assetDto.getValue();
            BigDecimal convertedValue = Currency.convert(fromCurrency, toCurrency, assetVal);
            assetDto.setValue(convertedValue);
        }
        for (LiabilityDto liabilityDto : emptyIfNull(liabilityRequestDto.getLiabilityDto())) {
            BigDecimal liabilityVal = liabilityDto.getValue();
            BigDecimal convertedValue = Currency.convert(fromCurrency, toCurrency, liabilityVal);
            liabilityDto.setValue(convertedValue);
        }
    }
}
