package ru.academits.belobrov.temperature.model.scales;

public interface TemperatureScale {
    double convertToCelsius(double temperature);

    double convertFromCelsius(double temperature);
}