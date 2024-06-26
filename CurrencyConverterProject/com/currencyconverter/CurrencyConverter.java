package com.currencyconverter;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Example exchange rates
        exchangeRates.put("USD", 1.00);
        exchangeRates.put("EUR", 0.94);
        exchangeRates.put("GBP", 0.79);
        exchangeRates.put("INR", 83.58);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return amount * (toRate / fromRate);
    }
}
