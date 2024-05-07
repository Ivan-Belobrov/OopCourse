package ru.academits.belobrov.temperature.model;

import ru.academits.belobrov.temperature.model.scales.*;

import java.util.List;

public class Model {
    private final List<TemperatureScale> temperatureScales;

    public Model(List<TemperatureScale> temperatureScales){
        this.temperatureScales = temperatureScales;
    }

    public double convertTemperature(double temperature, String fromScale, String toScale) {
        if (fromScale == null || toScale == null) {
            throw new IllegalArgumentException("Выберите шкалы для конвертации.");
        }

        if (fromScale.equalsIgnoreCase(toScale)) {
            return temperature;
        }

        TemperatureScale fromScaleName = temperatureScales.stream()
                .filter(scale -> scale.toString().equalsIgnoreCase(fromScale))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу."));

        TemperatureScale toScaleName = temperatureScales.stream()
                .filter(scale -> scale.toString().equalsIgnoreCase(toScale))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Неверный ввод. Пожалуйста введите действительную шкалу."));

        double temperatureInCelsius = fromScaleName.convertToCelsius(temperature);
        return toScaleName.convertFromCelsius(temperatureInCelsius);
    }}