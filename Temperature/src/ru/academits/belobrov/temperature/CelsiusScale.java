package ru.academits.belobrov.temperature;

import ru.academits.belobrov.TemperatureScale;

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
