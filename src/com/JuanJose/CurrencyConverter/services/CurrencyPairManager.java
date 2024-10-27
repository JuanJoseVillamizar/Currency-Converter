package com.JuanJose.CurrencyConverter.services;

import java.util.HashMap;
import java.util.Map;

public class CurrencyPairManager {
    private final Map<Integer, String[]> currencyPairs;

    public CurrencyPairManager(){
        currencyPairs = new HashMap<>();
        currencyPairs.put(1, new String[]{Currency.USD, Currency.ARS});
        currencyPairs.put(2, new String[]{Currency.ARS, Currency.USD});
        currencyPairs.put(3, new String[]{Currency.USD, Currency.BRL});
        currencyPairs.put(4, new String[]{Currency.BRL, Currency.USD});
        currencyPairs.put(5, new String[]{Currency.USD, Currency.COP});
        currencyPairs.put(6, new String[]{Currency.COP, Currency.USD});
    }

    public String[] getCurrencyPair(int option){
        return currencyPairs.get(option);
    }

    public boolean isValidOption (int option){
        return currencyPairs.containsKey(option);
    }

}
