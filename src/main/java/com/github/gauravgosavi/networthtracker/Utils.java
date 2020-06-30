package com.github.gauravgosavi.networthtracker;

import com.github.gauravgosavi.networthtracker.service.enums.Currency;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Utils {

    public static String getFormattedCurrency(Currency toCurrency, BigDecimal value) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(toCurrency.getLocale());
        java.util.Currency currency = java.util.Currency.getInstance(toCurrency.getCurrencyCode());
        numberFormat.setCurrency(currency);
        return numberFormat.format(value);
    }

    @SneakyThrows
    public static String getFormattedCurrency(Currency toCurrency, String value) {

        Number number = NumberFormat.getCurrencyInstance(toCurrency.getLocale()).parse(value);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(toCurrency.getLocale());
        return numberFormat.format(number);
    }
}
