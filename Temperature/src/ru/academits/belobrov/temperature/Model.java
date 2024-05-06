package ru.academits.belobrov.temperature;

import ru.academits.belobrov.scales.CelsiusScale;
import ru.academits.belobrov.scales.FahrenheitScale;
import ru.academits.belobrov.scales.KelvinScale;
import ru.academits.belobrov.scales.TemperatureScale;

import javax.swing.*;

public class Model {

    public static double convertTemperature(double temperature, String fromScale, String toScale) {
        if (fromScale == null || toScale == null) {
            throw new IllegalArgumentException("Выберите шкалы для конвертации.");
        }

        if (fromScale.equalsIgnoreCase(toScale)) {
            return temperature;
        }

        TemperatureScale fromTemperatureScale;
        TemperatureScale toTemperatureScale;

        fromTemperatureScale = switch (fromScale.toLowerCase()) {
            case "цельсия" -> new CelsiusScale();
            case "фаренгейта" -> new FahrenheitScale();
            case "кельвина" -> new KelvinScale();
            default ->
                    throw new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).");
        };

        toTemperatureScale = switch (toScale.toLowerCase()) {
            case "цельсия" -> new CelsiusScale();
            case "фаренгейта" -> new FahrenheitScale();
            case "кельвина" -> new KelvinScale();
            default ->
                    throw new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).");
        };

        double temperatureInCelsius = fromTemperatureScale.converterToCelsius(temperature);
        return toTemperatureScale.converterFromCelsius(temperatureInCelsius);
    }}