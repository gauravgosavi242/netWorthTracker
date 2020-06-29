package com.github.gauravgosavi.networthtracker.service.enums;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum Currency {
    USD(1, "USD", 1.0),
    CAD(2, "CAD", 1.3),
    AUD(3, "AUD", 1.4),
    EUR(4, "EUR", 0.8),
    GBP(5, "GBP", 0.8),
    INR(6, "INR", 76.2),
    CHF(7, "CHF", 0.9),
    JPY(8, "JPY", 106.8),
    CNY(9, "CNY", 7.0),
    NZD(10, "NZY", 1.5);

    private int id;
    private String currencyCode;
    private BigDecimal exchangeRate;

    Currency(int id, String currencyCode, Double exchangeRate) {
        this.id=id;
        this.currencyCode = currencyCode;
        this.exchangeRate = BigDecimal.valueOf(exchangeRate);
    }

    public static Currency fromCurrencyCode(String currencyCode){
        return Arrays.stream(Currency.values()).filter(currency -> currency.getCurrencyCode().equals(currencyCode)).findAny().orElseThrow(
                ()-> new RuntimeException("Currency not found for "+ currencyCode)
        );
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public static BigDecimal convert(Currency from, Currency to, BigDecimal amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        BigDecimal toUSD = amount.multiply((from.getExchangeRate()));
        return toUSD.multiply((to.getExchangeRate())).setScale(2, RoundingMode.CEILING);
    }

    public static String convertWithFormatting(Currency from, Currency to, BigDecimal amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        BigDecimal toUSD = amount.multiply((from.getExchangeRate()));

        BigDecimal convertedAmt = toUSD.multiply((to.getExchangeRate())).setScale(2, RoundingMode.CEILING);

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

    public Integer getID() {
        return this.id;
    }
}
