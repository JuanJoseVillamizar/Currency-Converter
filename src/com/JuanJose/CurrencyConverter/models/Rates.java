package com.JuanJose.CurrencyConverter.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Rates {
    private String result;
    private String base_code;
    private String target_code;
    private Double amount;
    private Double conversion_rate;
    private Double conversion_result;
    private String conversion;
    private String timestamp;


    public Rates(String result, String base_code, String target_code, Double amount, Double conversion_rate, Double conversion_result, String conversion) {
        this.result = result;
        this.base_code = base_code;
        this.target_code = target_code;
        this.amount = amount;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
        this.conversion= conversion;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setConversion_result(Double conversion_result) {
        this.conversion_result = conversion_result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    public void setConvertion_result(Double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "( " +
                "'result' : '" + result + '\'' + "\n" +
                "'base_code' : '" + base_code + '\'' + "\n" +
                "'target_code' : '" + target_code + '\'' + "\n" +
                "'amount' : " + amount + "\n" +
                "'conversion_rate' : " + conversion_rate + "\n" +
                "'conversion_result' : " + conversion_result + "\n" +
                "'conversion' : '" + conversion + '\'' + "\n" +
                "'timestamp' : " + timestamp + '\'' + "\n" +
                ')';
    }
}
