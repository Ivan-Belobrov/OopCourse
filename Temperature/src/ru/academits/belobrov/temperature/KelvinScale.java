package ru.academits.belobrov.temperature;

import ru.academits.belobrov.TemperatureScale;

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