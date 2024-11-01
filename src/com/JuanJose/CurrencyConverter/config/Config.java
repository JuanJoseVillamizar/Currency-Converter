package com.JuanJose.CurrencyConverter.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private static final String ENV_FILE = ".env";
    private Map<String, String> properties = new HashMap<>();

    public Config() {
        loadEnv();
    }

    private void loadEnv() {
        try (BufferedReader br = new BufferedReader(new FileReader(ENV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    properties.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration: " + e.getMessage(), e);
        }
    }

    public String get(String key) {
        return properties.get(key);
    }
}

