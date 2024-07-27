package com.widat.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {
    static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
    public static String formatToRupiah(double amount){
        return currencyFormatter.format(amount);
    }
}
