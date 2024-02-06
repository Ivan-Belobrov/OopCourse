package ru.academits.belobrov.temperature;

import ru.academits.belobrov.TemperatureScale;

public class FahrenheitScale implements TemperatureScale {
    @Override
    public double converterToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double converterFromCelsius(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
