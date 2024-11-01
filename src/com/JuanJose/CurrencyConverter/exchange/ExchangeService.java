package com.JuanJose.CurrencyConverter.exchange;

import com.JuanJose.CurrencyConverter.config.Config;
import com.JuanJose.CurrencyConverter.models.Rates;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    private final String API_KEY;

    public ExchangeService() {
        Config config = new Config();
        API_KEY = config.get("EXCHANGE_API_KEY");
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalArgumentException("API Key is missing or invalid. Please check your configuration.");
        }
    }

    public Rates fetchRates(String baseCurrent, String targetCurrent, double amount) throws IOException, InterruptedException {
        String URL_API = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + baseCurrent + "/" + targetCurrent + "/" + amount;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .build();
            HttpResponse<String> response;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new IOException("Network error occurred. Please check your internet connection.");
            }

            if (response.statusCode() != 200) {
                throw new IOException("Error from API: " + response.body() + " (Status code: " + response.statusCode() + ")");
            }

            return parseResponse(response.body());
        }
    }

    public Rates parseResponse(String jsonResponse) {
        Gson gson = new GsonBuilder()
                .create();
        return gson.fromJson(jsonResponse, Rates.class);
    }

}
