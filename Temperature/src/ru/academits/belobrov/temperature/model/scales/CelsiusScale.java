package ru.academits.belobrov.temperature.model.scales;

public class CelsiusScale implements TemperatureScale {
    @Override
    public double convertToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public String toString() {
        return "Цельсия";
    }
}