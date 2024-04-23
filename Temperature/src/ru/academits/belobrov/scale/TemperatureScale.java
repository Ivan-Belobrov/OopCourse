package ru.academits.belobrov.scale;

public interface TemperatureScale {
    double converterToCelsius(double temperature);
    double converterFromCelsius(double temperature);
}