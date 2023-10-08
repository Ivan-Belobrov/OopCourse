package ru.academits.belobrov.temperatureConverter;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(TemperatureConverter::new);
    }
}