package com.JuanJose.CurrencyConverter;

import com.JuanJose.CurrencyConverter.exchange.ExchangeService;
import com.JuanJose.CurrencyConverter.models.Rates;
import com.JuanJose.CurrencyConverter.constans.Currency;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeService exchanges = new ExchangeService();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        while (true) {
            displayMenu();
            int option = getOption(scanner);
            if (option == 7) break;
            double amount = getAmount(scanner);
            if (amount <= 0) continue;
            try {
                switch (option) {
                    case 1 -> convertCurrency(exchanges, Currency.USD, Currency.ARS, amount);
                    case 2 -> convertCurrency(exchanges, Currency.ARS, Currency.USD, amount);
                    case 3 -> convertCurrency(exchanges, Currency.USD, Currency.BRL, amount);
                    case 4 -> convertCurrency(exchanges, Currency.BRL, Currency.USD, amount);
                    case 5 -> convertCurrency(exchanges, Currency.USD, Currency.COP, amount);
                    case 6 -> convertCurrency(exchanges, Currency.COP, Currency.USD, amount);
                    default -> System.out.println("Please choose a valid option");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("An error occurred while fetching rates: " + e.getMessage());
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

    public static int getOption(Scanner scanner) {
        int option = -1;
        while (option == -1) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > 7) {
                    System.out.println("Please enter a valid option (1-7).");
                }
            } else {
                System.out.println("Please enter a valid option (1-7).");
                scanner.next();
            }
        }
        return option;
    }

    public static double getAmount(Scanner scanner) {
        double amount = -1;
        while (amount <= 0) {
            System.out.println("Please enter the amount you wish to convert:");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                }
            } else {
                scanner.next();
                System.out.println("Please enter a valid number.");
            }
        }
        return amount;
    }

    public static void convertCurrency(ExchangeService exchanges, String base, String target, double amount) throws IOException, InterruptedException {
        Rates rates = exchanges.fetchRates(base, target, amount);
        double result = rates.getConversion_result();
        System.out.printf("%.2f %s = %.2f %s%n", amount, base, result, target);
    }
}