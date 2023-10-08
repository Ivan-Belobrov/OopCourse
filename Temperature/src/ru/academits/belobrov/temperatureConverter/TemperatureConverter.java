package ru.academits.belobrov.temperatureConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private final JTextField inputField;
    private final JLabel resultLabel;
    private final JComboBox<String> fromScaleComboBox;
    private final JComboBox<String> toScaleComboBox;
    private static final String[] TEMPERATURE_SCALES = {"Celsius", "Fahrenheit", "Kelvin"};

    public TemperatureConverter() {
        setTitle("Преобразователь температуры");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Введите температура:");
        inputField = new JTextField(10);
        JButton convertButton = new JButton("Преобразовать");
        convertButton.addActionListener(new ConvertButtonListener());

        JLabel fromScaleLabel = new JLabel("От");
        fromScaleComboBox = new JComboBox<>(TEMPERATURE_SCALES);

        JLabel toScaleLabel = new JLabel("До");
        toScaleComboBox = new JComboBox<>(TEMPERATURE_SCALES);

        JLabel resultTextLabel = new JLabel("Результат:");
        resultLabel = new JLabel();

        add(inputLabel);
        add(inputField);
        add(convertButton);
        add(fromScaleLabel);
        add(fromScaleComboBox);
        add(toScaleLabel);
        add(toScaleComboBox);
        add(resultTextLabel);
        add(resultLabel);


        pack();
        setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            try {
                double temperature = Double.parseDouble(input);
                String fromScale = (String) fromScaleComboBox.getSelectedItem();
                String toScale = (String) toScaleComboBox.getSelectedItem();
                String result = convertTemperature(temperature, fromScale, toScale);
                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TemperatureConverter.this,
                        "Неверный ввод. Пожалуйста введите температуру.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                resultLabel.setText("");
            }
        }
    }

    private String convertTemperature(double temperature, String fromScale, String toScale) {
        if (fromScale == null || toScale == null) {
            JOptionPane.showMessageDialog(TemperatureConverter.this, "Выберите шкалы для конвертации.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return "";
        }
        double result;
        if (fromScale.equalsIgnoreCase("Celsius") && toScale.equalsIgnoreCase("Fahrenheit")) {
            result = (temperature * 9 / 5) + 32;
        } else if (fromScale.equalsIgnoreCase("Celsius") && toScale.equalsIgnoreCase("Kelvin")) {
            result = temperature + 273.15;
        } else if (fromScale.equalsIgnoreCase("Fahrenheit") && toScale.equalsIgnoreCase("Celsius")) {
            result = (temperature - 32) * 5 / 9;
        } else if (fromScale.equalsIgnoreCase("Fahrenheit") && toScale.equalsIgnoreCase("Kelvin")) {
            result = (temperature + 459.67) * 5 / 9;
        } else if (fromScale.equalsIgnoreCase("Kelvin") && toScale.equalsIgnoreCase("Celsius")) {
            result = temperature - 273.15;
        } else if (fromScale.equalsIgnoreCase("Kelvin") && toScale.equalsIgnoreCase("Fahrenheit")) {
            result = (temperature * 9 / 5) - 459.67;
        } else {
            JOptionPane.showMessageDialog(TemperatureConverter.this,
                    "Неверный ввод. Пожалуйста введите действительную шкалу (Celsius, Fahrenheit, Kelvin).",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        return String.format("%s = %.2f, %s = %.2f ", fromScale, temperature, toScale, result);
    }
}