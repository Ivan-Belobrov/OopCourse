package ru.academits.belobrov.temperature.model.scales;

public class KelvinScale implements TemperatureScale {
    @Override
    public double convertToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public String toString(){
        return "Кельвина";
    }
}