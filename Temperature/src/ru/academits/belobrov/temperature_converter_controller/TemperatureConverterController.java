package ru.academits.belobrov.temperature_converter_controller;

import ru.academits.belobrov.temperature_converter.TemperatureConverter;
import ru.academits.belobrov.temperature_converter_model.TemperatureConverterModel;

public class TemperatureConverterController {
    private final TemperatureConverter view;

    public TemperatureConverterController(TemperatureConverter view) {
        this.view = view;
    }

    public void convertTemperature() {
        String input = view.getInputTemperature();

        try {
            double temperature = Double.parseDouble(input);
            String fromScale = view.getFromScale();
            String toScale = view.getToScale();
            double result = TemperatureConverterModel.convertTemperature(temperature, fromScale, toScale);
            view.setResult(String.format("%s = %.2f, %s = %.2f ", fromScale, temperature, toScale, result));
        } catch (NumberFormatException e) {
            view.showError("Неверный ввод. Пожалуйста введите число.");
            view.setResult("");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
            view.setResult("");
        }
    }
}