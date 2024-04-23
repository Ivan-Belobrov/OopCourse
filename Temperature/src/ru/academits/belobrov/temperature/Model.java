package ru.academits.belobrov.temperature;

import ru.academits.belobrov.scale.CelsiusScale;
import ru.academits.belobrov.scale.FahrenheitScale;
import ru.academits.belobrov.scale.KelvinScale;
import ru.academits.belobrov.scale.TemperatureScale;

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
            case "celsius" -> new CelsiusScale();
            case "fahrenheit" -> new FahrenheitScale();
            case "kelvin" -> new KelvinScale();
            default ->
                    throw new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).");
        };

        toTemperatureScale = switch (toScale.toLowerCase()) {
            case "celsius" -> new CelsiusScale();
            case "fahrenheit" -> new FahrenheitScale();
            case "kelvin" -> new KelvinScale();
            default ->
                    throw new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).");
        };

        double temperatureInCelsius = fromTemperatureScale.converterToCelsius(temperature);
        return toTemperatureScale.converterFromCelsius(temperatureInCelsius);
    }
}