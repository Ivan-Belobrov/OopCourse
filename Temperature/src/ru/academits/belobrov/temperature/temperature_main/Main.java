package ru.academits.belobrov.temperature.temperature_main;

import ru.academits.belobrov.temperature.controller.Controller;
import ru.academits.belobrov.temperature.model.Model;
import ru.academits.belobrov.temperature.model.scales.CelsiusScale;
import ru.academits.belobrov.temperature.model.scales.FahrenheitScale;
import ru.academits.belobrov.temperature.model.scales.KelvinScale;
import ru.academits.belobrov.temperature.model.scales.TemperatureScale;
import ru.academits.belobrov.temperature.view.View;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<TemperatureScale> temperatureScales = Arrays.asList(
                    new CelsiusScale(),
                    new FahrenheitScale(),
                    new KelvinScale()
            );

            Model model = new Model(temperatureScales);
            View view = new View(model);
            Controller controller = new Controller(view, model);
        });
    }
}