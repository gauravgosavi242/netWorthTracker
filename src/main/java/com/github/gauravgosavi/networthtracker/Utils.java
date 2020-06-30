package com.github.gauravgosavi.networthtracker;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String getFormattedCurrency(String toCurrency, BigDecimal value) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        java.util.Currency currency = java.util.Currency.getInstance(toCurrency);
        numberFormat.setCurrency(currency);
        return numberFormat.format(value);
    }
}
