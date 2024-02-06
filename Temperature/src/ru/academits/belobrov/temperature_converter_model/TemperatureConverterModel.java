package ru.academits.belobrov.temperature_converter_model;

public class TemperatureConverterModel {
    public static double convertTemperature(double temperature, String fromScale, String toScale) {
        if (fromScale == null || toScale == null) {
            throw new IllegalArgumentException("Выберите шкалы для конвертации.");
        }

        if (fromScale.equalsIgnoreCase(toScale)) {
            return temperature;
        }

        if (fromScale.equalsIgnoreCase("Celsius") && toScale.equalsIgnoreCase("Fahrenheit")) {
            return (temperature * 9 / 5) + 32;
        } else if (fromScale.equalsIgnoreCase("Celsius") && toScale.equalsIgnoreCase("Kelvin")) {
            return temperature + 273.15;
        } else if (fromScale.equalsIgnoreCase("Fahrenheit") && toScale.equalsIgnoreCase("Celsius")) {
            return (temperature - 32) * 5 / 9;
        } else if (fromScale.equalsIgnoreCase("Fahrenheit") && toScale.equalsIgnoreCase("Kelvin")) {
            return (temperature + 459.67) * 5 / 9;
        } else if (fromScale.equalsIgnoreCase("Kelvin") && toScale.equalsIgnoreCase("Celsius")) {
            return temperature - 273.15;
        } else if (fromScale.equalsIgnoreCase("Kelvin") && toScale.equalsIgnoreCase("Fahrenheit")) {
            return (temperature * 9 / 5) - 459.67;
        } else {
            throw new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).");
        }
    }
}