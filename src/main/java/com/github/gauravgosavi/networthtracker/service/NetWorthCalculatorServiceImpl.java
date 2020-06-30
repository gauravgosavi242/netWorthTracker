package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.Utils;
import com.github.gauravgosavi.networthtracker.model.request.AssetDto;
import com.github.gauravgosavi.networthtracker.model.request.AssetRequestDto;
import com.github.gauravgosavi.networthtracker.model.request.LiabilityDto;
import com.github.gauravgosavi.networthtracker.model.request.LiabilityRequestDto;
import com.github.gauravgosavi.networthtracker.model.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.model.response.AssetResponseDto;
import com.github.gauravgosavi.networthtracker.model.response.LiabilityResponseDto;
import com.github.gauravgosavi.networthtracker.model.response.NetWorthInfoDto;
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
    public NetWorthInfoDto convertToCurrency(NetWorthInfoDto requestDto, String fromCurrency, String toCurrency) {


        //Convert incoming DTO's values into formatted currencies

        currencyConvertIncomingRequests(requestDto.getAssetDtos(), requestDto.getLiabilityDto(),
                Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(toCurrency));

        requestDto.setCurrencyCode(toCurrency);
        requestDto.setNetAssets(Currency.convertWithFormatting(Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(toCurrency), requestDto.getNetAssets()));
        requestDto.setNetLiabilites(Currency.convertWithFormatting(Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(toCurrency), requestDto.getNetLiabilites()));
        requestDto.setNetworthAmount(Currency.convertWithFormatting(Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(toCurrency), requestDto.getNetworthAmount()));

        return requestDto;
    }

    @Override
    public NetWorthInfoDto calculate(NetWorthRequestDto requestDto, String currency) {
        AssetRequestDto assetRequestDto = requestDto.getAssetRequestDto();
        LiabilityRequestDto liabilityRequestDto = requestDto.getLiabilityRequestDto();

        return computeWorths(Currency.fromCurrencyCode(currency), assetRequestDto, liabilityRequestDto);
    }

    private NetWorthInfoDto computeWorths(Currency toCurrency, AssetRequestDto assetRequestDto, LiabilityRequestDto liabilityRequestDto) {
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

        return new NetWorthInfoDto(
                getAssetResponseDtos(assetRequestDto.getAssetDtos(), toCurrency),
                getLiabilityResponseDtos(liabilityRequestDto.getLiabilityDto(), toCurrency),
                Utils.getFormattedCurrency(toCurrency, assetValue),
                Utils.getFormattedCurrency(toCurrency, liabilityValue),
                Utils.getFormattedCurrency(toCurrency, networth), toCurrency.getCurrencyCode());
    }



    private List<AssetResponseDto> getAssetResponseDtos(List<AssetDto> assetDtos, Currency toCurrency) {
        return emptyIfNull(assetDtos).stream().map(assetDto -> new AssetResponseDto(assetDto, toCurrency)).collect(Collectors.toList());
    }

    private List<LiabilityResponseDto> getLiabilityResponseDtos(List<LiabilityDto> liabilityDtos, Currency toCurrency) {
        return emptyIfNull(liabilityDtos).stream().map(liabilityDto -> new LiabilityResponseDto(liabilityDto, toCurrency)).collect(Collectors.toList());
    }

    private void currencyConvertIncomingRequests(List<AssetResponseDto> assetResponseDtos, List<LiabilityResponseDto> liabilityResponseDtos, Currency fromCurrency, Currency toCurrency) {
        for (AssetResponseDto assetDto : emptyIfNull(assetResponseDtos)) {
            String value = assetDto.getValue();
            assetDto.setValue(Utils.getFormattedCurrency(toCurrency, Currency.convertWithFormatting(fromCurrency, toCurrency,value)));
        }
        for (LiabilityResponseDto liabilityDto : emptyIfNull(liabilityResponseDtos)) {
            String value = liabilityDto.getValue();
            liabilityDto.setValue(Utils.getFormattedCurrency(toCurrency, Currency.convertWithFormatting(fromCurrency, toCurrency,value)));
        }


    }
}
