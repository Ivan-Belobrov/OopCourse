package ru.academits.belobrov.scale;

public class CelsiusScale implements TemperatureScale {
    @Override
    public double converterToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double converterFromCelsius(double temperature) {
        return temperature;
    }
}