package ru.academits.belobrov.temperature;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void convertTemperature() {
        String inputNumber = view.getInputTemperature();

        try {
            double temperature = Double.parseDouble(inputNumber);
            String fromScaleName = view.getFromScaleName();
            String toScaleName = view.getToScaleName();
            double result = Model.convertTemperature(temperature, fromScaleName, toScaleName);
            view.setResult(String.format("%s = %.2f, %s = %.2f ", fromScaleName, temperature, toScaleName, result));
            view.clearInputField();
        } catch (NumberFormatException e) {
            view.showError("Неверный ввод. Пожалуйста введите число.");
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
            view.setResult("");
        }
    }
}