package ru.academits.belobrov.scales;

public interface TemperatureScale {
    double converterToCelsius(double temperature);
    double converterFromCelsius(double temperature);
}