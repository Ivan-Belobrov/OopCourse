package ru.academits.belobrov.scale;

public class KelvinScale implements TemperatureScale {
    @Override
    public double converterToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double converterFromCelsius(double temperature) {
        return temperature + 273.15;
    }
}