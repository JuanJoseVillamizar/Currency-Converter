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
                 int option = scanner.nextInt();
                if (option == 7) {
                    break;
                }
                System.out.println("Please enter the amount you wish to convert:");
                try {
                    double amount = scanner.nextDouble();
                    switch (option) {
                        case 1:
                            Rates rate1 = exchanges.fetchRates("USD", "ARS", amount);
                            result = rate1.getConversion_result();
                            System.out.println(amount + " USD = " + result + " ARS");
                            break;
                        case 2:
                            Rates rate2 = exchanges.fetchRates("ARS", "USD", amount);
                            result = rate2.getConversion_result();
                            System.out.println(amount + " ARS = " + result + " USD");
                            break;
                        case 3:
                            Rates rate3 = exchanges.fetchRates("USD", "BRL", amount);
                            result = rate3.getConversion_result();
                            System.out.println(amount + " USD = " + result + " BRL");
                            break;
                        case 4:
                            Rates rate4 = exchanges.fetchRates("BRL", "USD", amount);
                            result = rate4.getConversion_result();
                            System.out.println(amount + " BRL = " + result + " USD");
                            break;
                        case 5:
                            Rates rate5 = exchanges.fetchRates("USD", "COP", amount);
                            result = rate5.getConversion_result();
                            System.out.println(amount + " USD = " + result + " COP");
                            break;
                        case 6:
                            Rates rate6 = exchanges.fetchRates("COP", "USD", amount);
                            result = rate6.getConversion_result();
                            System.out.println(amount + " COP = " + result + " USD");
                            break;
                        default:
                            System.out.println("Please choose a valid option");
                            break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
        }
        System.out.println("EXIT...");
        scanner.close();
    }
}