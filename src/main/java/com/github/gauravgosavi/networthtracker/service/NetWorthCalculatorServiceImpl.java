package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.request.AssetDto;
import com.github.gauravgosavi.networthtracker.dto.request.AssetRequestDto;
import com.github.gauravgosavi.networthtracker.dto.request.LiabilityDto;
import com.github.gauravgosavi.networthtracker.dto.request.LiabilityRequestDto;
import com.github.gauravgosavi.networthtracker.dto.request.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.response.AssetsResponseDto;
import com.github.gauravgosavi.networthtracker.dto.response.LiabilitiesResponseDto;
import com.github.gauravgosavi.networthtracker.dto.response.NetWorthCurrencyConversionDto;
import com.github.gauravgosavi.networthtracker.dto.response.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service("networthCalculatorService")
public class NetWorthCalculatorServiceImpl implements NetworthCalculatorService {

    private static final Currency DEFAULT_CURRENCY = Currency.USD; // Assuming default currency to be USD

    @Override
    @Deprecated
    public NetWorthResponseDto calculate(NetWorthRequestDto requestDto) {
        log.info("Received request");
        log.debug("Detail request {}", requestDto);

        BigDecimal netWorth;

        //Add assets
        BigDecimal netAssets = BigDecimal.ZERO;
        netAssets = netAssets.add(requestDto.getAssetsDto().getChequingBalance())
                .add(requestDto.getAssetsDto().getSavingsForTaxes())
                .add(requestDto.getAssetsDto().getRainyDayFund())
                .add(requestDto.getAssetsDto().getSavingsForFun())
                .add(requestDto.getAssetsDto().getSavingsForTravel())
                .add(requestDto.getAssetsDto().getSavingsForPersonalDevelopment())
                .add(requestDto.getAssetsDto().getInvestment1())
                .add(requestDto.getAssetsDto().getInvestment2())
                .add(requestDto.getAssetsDto().getInvestment3())
                .add(requestDto.getAssetsDto().getInvestment4())
                .add(requestDto.getAssetsDto().getInvestment5())
                .add(requestDto.getAssetsDto().getPrimaryHome())
                .add(requestDto.getAssetsDto().getSecondHome())
                .add(requestDto.getAssetsDto().getOthers())
                .add(requestDto.getAssetsDto().getLongTermAssets());


        //Add Liabilities
        BigDecimal netLiabilities = BigDecimal.ZERO;
        netLiabilities = netLiabilities.add(requestDto.getLiabilitiesDto().getCreditCard1())
                .add(requestDto.getLiabilitiesDto().getCreditCard2())
                .add(requestDto.getLiabilitiesDto().getOther())
                .add(requestDto.getLiabilitiesDto().getMortgage1())
                .add(requestDto.getLiabilitiesDto().getMortgage2())
                .add(requestDto.getLiabilitiesDto().getLineOfCredit())
                .add(requestDto.getLiabilitiesDto().getInvestmentLoan())
                .add(requestDto.getLiabilitiesDto().getStudentLoan())
                .add(requestDto.getLiabilitiesDto().getCarLoan());


        netWorth = netAssets.subtract(netLiabilities);

        String currencyCode = StringUtils.isNotBlank(requestDto.getCurrencyCode()) ? requestDto.getCurrencyCode() : DEFAULT_CURRENCY.getCurrencyCode();

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        java.util.Currency currency = java.util.Currency.getInstance(currencyCode);
        numberFormat.setCurrency(currency);
        String netWorthAsString = numberFormat.format(netWorth);

        Assert.notNull(netWorthAsString, "Need non null net worth");

        return new NetWorthResponseDto(null, null, netWorthAsString, currencyCode);

    }

    @Override
    @Deprecated
    public NetWorthCurrencyConversionDto calculateWithCurrency(NetWorthRequestDto requestDto, String fromCurr) {

        log.info("Converting to {}", fromCurr);
        Currency fromCurrency = Currency.fromCurrencyCode(fromCurr);
        Currency toCurrency = Currency.fromCurrencyCode(requestDto.getCurrencyCode());

        AssetsResponseDto assetsDto = new AssetsResponseDto();

        assetsDto.setChequingBalance(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getChequingBalance()));
        assetsDto.setSavingsForTaxes(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getSavingsForTaxes()));
        assetsDto.setRainyDayFund(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getRainyDayFund()));
        assetsDto.setSavingsForFun(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getSavingsForFun()));
        assetsDto.setSavingsForTravel(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getSavingsForTravel()));
        assetsDto.setSavingsForPersonalDevelopment(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getSavingsForPersonalDevelopment()));
        assetsDto.setInvestment1(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getInvestment1()));
        assetsDto.setInvestment2(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getInvestment2()));
        assetsDto.setInvestment3(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getInvestment3()));
        assetsDto.setInvestment4(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getInvestment4()));
        assetsDto.setInvestment5(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getInvestment5()));
        assetsDto.setPrimaryHome(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getPrimaryHome()));
        assetsDto.setSecondHome(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getSecondHome()));
        assetsDto.setOthers(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getOthers()));
        assetsDto.setLongTermAssets(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getAssetsDto().getLongTermAssets()));

        LiabilitiesResponseDto liabilitiesDto = new LiabilitiesResponseDto();

        liabilitiesDto.setCreditCard1(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getCreditCard1()));
        liabilitiesDto.setCreditCard2(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getCreditCard2()));
        liabilitiesDto.setOther(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getOther()));
        liabilitiesDto.setMortgage1(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getMortgage1()));
        liabilitiesDto.setMortgage2(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getMortgage2()));
        liabilitiesDto.setLineOfCredit(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getLineOfCredit()));
        liabilitiesDto.setInvestmentLoan(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getInvestmentLoan()));
        liabilitiesDto.setStudentLoan(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getStudentLoan()));
        liabilitiesDto.setCarLoan(Currency.convertWithFormatting(fromCurrency, toCurrency, requestDto.getLiabilitiesDto().getCarLoan()));

        NetWorthResponseDto netWorthResponseDto = calculate(requestDto);

        return new NetWorthCurrencyConversionDto(assetsDto, liabilitiesDto, Currency.convertWithFormatting(fromCurrency, toCurrency,
                netWorthResponseDto.getNetworthAmount()
        ), requestDto.getCurrencyCode());
    }

    @Override
    public NetWorthResponseDto calculateWithCurrencyV2(NetWorthRequestDto requestDto, String fromCurrency) {
        AssetRequestDto assetRequestDto = requestDto.getAssetRequestDto();
        LiabilityRequestDto liabilityRequestDto = requestDto.getLiabilityRequestDto();

        currencyConvertIncomingRequests(assetRequestDto, liabilityRequestDto,
                Currency.fromCurrencyCode(fromCurrency), Currency.fromCurrencyCode(requestDto.getCurrencyCode()));

        Optional<BigDecimal> assetValueOptional = assetRequestDto.getAssetDtos().stream().map(AssetDto::getValue)
                .collect(Collectors.toList()).stream()
                .reduce(BigDecimal::add);

        BigDecimal assetValue = assetValueOptional.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.CEILING);
        log.info("Net assets {}", assetValue);

        Optional<BigDecimal> liabilityValueOptional = liabilityRequestDto.getLiabilityDto().stream().map(LiabilityDto::getValue)
                .collect(Collectors.toList()).stream()
                .reduce(BigDecimal::add);

        BigDecimal liabilityValue = liabilityValueOptional.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.CEILING);

        log.info("Net Liability {}", liabilityValue);

        BigDecimal networth = assetValue.subtract(liabilityValue);

        log.info("Net Worth {}", networth);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        java.util.Currency currency = java.util.Currency.getInstance(requestDto.getCurrencyCode());
        numberFormat.setCurrency(currency);

        return new NetWorthResponseDto(assetRequestDto.getAssetDtos(), liabilityRequestDto.getLiabilityDto(), numberFormat.format(networth), requestDto.getCurrencyCode());
    }

    private void currencyConvertIncomingRequests(AssetRequestDto assetRequestDto, LiabilityRequestDto liabilityRequestDto, Currency fromCurrency, Currency toCurrency) {
        for (AssetDto assetDto : assetRequestDto.getAssetDtos()) {
            BigDecimal assetVal = assetDto.getValue();
            BigDecimal convertedValue = Currency.convert(fromCurrency, toCurrency, assetVal);
            assetDto.setValue(convertedValue);
        }
        for (LiabilityDto liabilityDto : liabilityRequestDto.getLiabilityDto()) {
            BigDecimal liabilityVal = liabilityDto.getValue();
            BigDecimal convertedValue = Currency.convert(fromCurrency, toCurrency, liabilityVal);
            liabilityDto.setValue((convertedValue));
        }
    }
}
