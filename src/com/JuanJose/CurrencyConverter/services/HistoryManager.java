package com.JuanJose.CurrencyConverter.services;

import com.JuanJose.CurrencyConverter.models.Rates;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private List<Rates> conversions = new ArrayList<>();
    public void addConversions (Rates rates){
        conversions.add(rates);
    }
    public void displayMenu (){
        conversions.forEach(System.out::println);
    }
    public void savedToJson (String listName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(listName)){
            writer.write(gson.toJson(conversions));
        }
    }
}
