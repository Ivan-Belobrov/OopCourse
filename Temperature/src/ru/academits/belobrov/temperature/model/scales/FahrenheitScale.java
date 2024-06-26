package ru.academits.belobrov.temperature.model.scales;

public class FahrenheitScale implements TemperatureScale {
    @Override
    public double convertToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature * 9 / 5 + 32;
    }

    @Override
    public String toString(){
        return "Фаренгейта";
    }
}