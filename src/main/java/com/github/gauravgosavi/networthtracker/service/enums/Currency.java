package com.github.gauravgosavi.networthtracker.service.enums;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum Currency {
    USD("USD", 1.0),
    CAD("CAD", 1.3),
    AUD("AUD", 1.4),
    EUR("EUR", 0.8),
    GBP("GBP", 0.8),
    INR("INR", 76.2),
    CHF("CHF", 0.9),
    JPY("JPY", 106.8),
    CNY("CNY", 7.0),
    NZD("NZY", 1.5);

    private String currencyCode;
    private Double exchangeRate;

    Currency(String currencyCode, Double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public static Currency fromCurrencyCode(String currencyCode){
        return Arrays.stream(Currency.values()).filter(currency -> currency.getCurrencyCode().equals(currencyCode)).findAny().orElseThrow(
                ()-> new RuntimeException("Currency not found for "+ currencyCode)
        );
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public static BigDecimal convert(Currency from, Currency to, BigDecimal amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        BigDecimal toUSD = amount.multiply(new BigDecimal(from.getExchangeRate()));
        return toUSD.multiply(new BigDecimal(to.getExchangeRate()));
    }

    public static String convertWithFormatting(Currency from, Currency to, BigDecimal amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        BigDecimal toUSD = amount.multiply(new BigDecimal(from.getExchangeRate()));

        BigDecimal convertedAmt = toUSD.multiply(new BigDecimal(to.getExchangeRate()));

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        java.util.Currency currency = java.util.Currency.getInstance(to.getCurrencyCode());
        numberFormat.setCurrency(currency);

        return numberFormat.format(convertedAmt);
    }

    public static String convertWithFormatting(Currency from, Currency to, String amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        String amountWithoutCurrencyCode = amount.replaceAll("[^A-Za-z0-9]", "");
        return convertWithFormatting(from, to, new BigDecimal(amountWithoutCurrencyCode));
    }
}
