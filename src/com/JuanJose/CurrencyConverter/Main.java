package com.JuanJose.CurrencyConverter;

import com.JuanJose.CurrencyConverter.exchange.ExchangeService;
import com.JuanJose.CurrencyConverter.models.Rates;
import com.JuanJose.CurrencyConverter.services.CurrencyPairManager;
import com.JuanJose.CurrencyConverter.services.HistoryManager;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeService exchanges = new ExchangeService();
        HistoryManager history = new HistoryManager();
        CurrencyPairManager pairManager = new CurrencyPairManager();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        while (true) {
            displayMenu();
            int option = getOption(scanner);
            if (option == 12) break;
            if (option == 11) {
                history.displayMenu();
                continue;
            }
            if (!pairManager.isValidOption(option)) {
                System.out.println("Please enter a valid option (1-12).");
                continue;
            }
            double amount = getAmount(scanner);
            if (amount <= 0) continue;
            try {
                String[] currencies = pairManager.getCurrencyPair(option);
                convertCurrency(exchanges, currencies[0], currencies[1], amount,history);

            } catch (IOException | InterruptedException e) {
                System.out.println("An error occurred while fetching rates: " + e.getMessage());
            }
        }
        try {
            history.savedToJson("Conversions.json");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
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
                         7) Dolar --> Euro
                         8) Euro --> Dolar
                         9) Dolar --> Peso Mexicano
                         10) Peso Mexicano --> Dolar
                         11) View conversion history
                         12) Exit
                *********************************************************
                """);
    }

    public static int getOption(Scanner scanner) {
        int option = -1;
        while (option == -1) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > 12) {
                    System.out.println("Please enter a valid option (1-12).");
                }
            } else {
                System.out.println("Please enter a valid option (1-12).");
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

    public static String convertCurrency(ExchangeService exchanges, String base, String target, double amount, HistoryManager historyManager) throws IOException, InterruptedException {
        Rates rates = exchanges.fetchRates(base, target, amount);
        double result = rates.getConversion_result();
        String conversion = String.format("%.2f %s = %.2f %s%n", amount, base, result, target);
        System.out.println(conversion);
        Rates response = new Rates(
                "success",
                rates.getBase_code(),
                rates.getTarget_code(),
                amount,
                rates.getConversion_rate(),
                rates.getConversion_result(),
                conversion
        );
        historyManager.addConversions(response);
        return conversion;
    }
}