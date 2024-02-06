package ru.academits.belobrov.main_temperature_converter;

import ru.academits.belobrov.temperature_converter.TemperatureConverter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
        });
    }
}