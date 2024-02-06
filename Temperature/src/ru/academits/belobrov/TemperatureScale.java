package ru.academits.belobrov;

public interface TemperatureScale {
    double converterToCelsius(double temperature);

    double converterFromCelsius(double temperature);
}