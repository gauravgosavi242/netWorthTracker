package com.github.gauravgosavi.networthtracker.service.enums;

import lombok.SneakyThrows;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum Currency {
    USD(1, "USD", 1.0, Locale.US),
    CAD(2, "CAD", 1.3, Locale.CANADA),
    AUD(3, "AUD", 1.4, Locale.UK),
    EUR(4, "EUR", 0.8, Locale.FRANCE),
    GBP(5, "GBP", 0.8, Locale.UK),
    INR(6, "INR", 76.2, new Locale("en", "IN")),
    CHF(7, "CHF", 0.9, Locale.FRANCE),
    JPY(8, "JPY", 106.8, Locale.JAPAN),
    CNY(9, "CNY", 7.0, Locale.CHINA),
    NZD(10, "NZD", 1.5, Locale.UK);

    private int id;
    private String currencyCode;
    private BigDecimal exchangeRate;
    private Locale locale;

    Currency(int id, String currencyCode, Double exchangeRate, Locale locale) {
        this.id=id;
        this.currencyCode = currencyCode;
        this.exchangeRate = BigDecimal.valueOf(exchangeRate);
        this.locale = locale;
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
        BigDecimal toUSD = amount.divide(from.getExchangeRate(), RoundingMode.CEILING);
        return toUSD.multiply((to.getExchangeRate())).setScale(2, RoundingMode.CEILING);
    }

    public static String convertWithFormatting(Currency from, Currency to, BigDecimal amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        BigDecimal toUSD = amount.divide(from.getExchangeRate(), RoundingMode.CEILING);

        BigDecimal convertedAmt = toUSD.multiply((to.getExchangeRate())).setScale(2, RoundingMode.CEILING);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(to.getLocale());
        java.util.Currency currency = java.util.Currency.getInstance(to.getCurrencyCode());
        numberFormat.setCurrency(currency);

        return numberFormat.format(convertedAmt);
    }

    @SneakyThrows
    public static String convertWithFormatting(Currency from, Currency to, String amount){
        Assert.notNull(amount, "Need valid currency amount to convert");
        Number number = NumberFormat.getCurrencyInstance(from.getLocale()).parse(amount);
        return convertWithFormatting(from, to, new BigDecimal(number.doubleValue()));
    }

    public Integer getID() {
        return this.id;
    }

    public Locale getLocale() {
        return locale;
    }
}
