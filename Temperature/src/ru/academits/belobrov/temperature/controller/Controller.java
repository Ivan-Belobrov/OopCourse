package ru.academits.belobrov.temperature.controller;

import ru.academits.belobrov.temperature.model.Model;
import ru.academits.belobrov.temperature.view.View;

public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void convertTemperature() {
        String inputNumber = view.getInputTemperature();

        try {
            double temperature = Double.parseDouble(inputNumber);
            String fromScaleName = view.getFromScaleName();
            String toScaleName = view.getToScaleName();
            double result = model.convertTemperature(temperature, fromScaleName, toScaleName);
            view.setResult(temperature, fromScaleName, result, toScaleName);
            view.clearInputField();
        } catch (NumberFormatException e) {
            view.showError("Неверный ввод. Пожалуйста введите число.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
            view.setResult(0.0, "", 0.0, "");
        }
    }
}