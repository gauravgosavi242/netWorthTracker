package com.github.gauravgosavi.networthtracker.service;

import com.github.gauravgosavi.networthtracker.dto.NetWorthRequestDto;
import com.github.gauravgosavi.networthtracker.dto.NetWorthResponseDto;
import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
@Service("networthCalculatorService")
public class NetWorthCalculatorServiceImpl implements NetworthCalculatorService {

    private static final Currency DEFAULT_CURRENCY = Currency.USD; // Assuming default currency to be USD

    @Override
    public NetWorthResponseDto calculate(NetWorthRequestDto requestDto) {
        log.info("Received request");
        log.debug("Detail request {}", requestDto);

        BigDecimal netWorth;

        //Add assets
        BigDecimal netAssets = BigDecimal.ZERO;
        netAssets= netAssets.add(requestDto.getAssetsDto().getChequingBalance())
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
                .add(requestDto.getAssetsDto().getOthers());

        //Add Liabilities
        BigDecimal netLiabilites = BigDecimal.ZERO;
        netLiabilites = netLiabilites.add(requestDto.getLiabilitiesDto().getCreditCard1())
                .add(requestDto.getLiabilitiesDto().getCreditCard2())
                .add(requestDto.getLiabilitiesDto().getOther())
                .add(requestDto.getLiabilitiesDto().getLongTermDebt())
                .add(requestDto.getLiabilitiesDto().getMortgage1())
                .add(requestDto.getLiabilitiesDto().getMortgage2())
                .add(requestDto.getLiabilitiesDto().getLineOfCredit())
                .add(requestDto.getLiabilitiesDto().getInvestmentLoan())
                .add(requestDto.getLiabilitiesDto().getStudentLoan())
                .add(requestDto.getLiabilitiesDto().getCarLoan());


        netWorth = netAssets.subtract(netLiabilites);

        String currencyCode = StringUtils.isNotBlank(requestDto.getCurrencyCode()) ? requestDto.getCurrencyCode() : DEFAULT_CURRENCY.getCurrencyCode();

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        java.util.Currency currency = java.util.Currency.getInstance(currencyCode);
        numberFormat.setCurrency(currency);
        String netWorthAsString = numberFormat.format(netWorth);

        Assert.notNull(netWorthAsString, "Need non null net worth");

        return new NetWorthResponseDto(netWorthAsString, currencyCode);

    }
}
