package com.JuanJose.CurrencyConverter;

import com.JuanJose.CurrencyConverter.exchange.ExchangeService;
import com.JuanJose.CurrencyConverter.models.Rates;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExchangeService exchanges = new ExchangeService();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Double result;
        System.out.println("Choose one option");
        while (true) {
            displayMenu();
            int option = scanner.nextInt();
            if (option == 7) {
                break;
            }
            System.out.println("Please enter the amount you wish to convert:");
            if (scanner.hasNextDouble()){
                double amount = scanner.nextDouble();
                switch (option) {
                    case 1 -> convertCurrency(exchanges, "USD", "ARS", amount);
                    case 2 -> convertCurrency(exchanges, "ARS", "USD", amount);
                    case 3 -> convertCurrency(exchanges, "USD", "BRL", amount);
                    case 4 -> convertCurrency(exchanges, "BRL", "USD", amount);
                    case 5 -> convertCurrency(exchanges, "USD", "COP", amount);
                    case 6 -> convertCurrency(exchanges, "COP", "USD", amount);
                    default -> System.out.println("Please choose a valid option");
                }
            }else{
                System.out.println("Please enter a valid number.");
                scanner.next();
            }

        }
        System.out.println("EXIT...");
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("""
                *********************************************************
                         1) Dolar --> Peso Argentino
                         2) Peso Argentino --> Dolar
                         3) Dolar --> Real Brasileño
                         4) Real Brasileño --> Dolar
                         5) Dolar --> Peso Colombiano
                         6) Peso Colombiano --> Dolar
                         7) Exit
                *********************************************************
                """);
    }
    public  static void convertCurrency(ExchangeService exchanges, String base, String target, double amount) throws IOException, InterruptedException {
        Rates rates = exchanges.fetchRates(base,target,amount);
        double result = rates.getConversion_result();
        System.out.printf("%.2f %s = %.2f %s%n", amount, base, result, target);
    }
}