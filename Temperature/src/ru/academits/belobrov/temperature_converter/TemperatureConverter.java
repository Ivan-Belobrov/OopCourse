package ru.academits.belobrov.temperature_converter;

import ru.academits.belobrov.temperature_converter_controller.TemperatureConverterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    private final JFrame frame;
    private final JTextField inputField;
    private final JTextArea resultTextArea;
    private final JComboBox<String> fromScaleComboBox;
    private final JComboBox<String> toScaleComboBox;
    private static final String[] TEMPERATURE_SCALES = {"Celsius", "Fahrenheit", "Kelvin"};
    private final TemperatureConverterController controller;

    public TemperatureConverter() {
        frame = new JFrame();
        frame.setTitle("Преобразователь температуры");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel inputLabel = new JLabel("Введите температуру:");
        inputField = new JTextField(10);
        JButton convertButton = new JButton("Преобразовать");
        convertButton.addActionListener(new ConvertButtonListener());

        JLabel fromScaleLabel = new JLabel("От");
        fromScaleComboBox = new JComboBox<>(TEMPERATURE_SCALES);

        JLabel toScaleLabel = new JLabel("До");
        toScaleComboBox = new JComboBox<>(TEMPERATURE_SCALES);

        JLabel resultTextLabel = new JLabel("Результат:");
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setRows(1);

        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(inputLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(inputField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        frame.add(convertButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(fromScaleLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(fromScaleComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(toScaleLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(toScaleComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        frame.add(resultTextLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        frame.add(scrollPane, constraints);

        frame.setSize(300, 400);
        frame.setVisible(true);

        controller = new TemperatureConverterController(this);
    }

    public String getInputTemperature() {
        return inputField.getText();
    }

    public String getFromScale() {
        return (String) fromScaleComboBox.getSelectedItem();
    }

    public String getToScale() {
        return (String) toScaleComboBox.getSelectedItem();
    }

    public void setResult(String result) {
        resultTextArea.setText(result);
        resultTextArea.setRows(result.split("\n").length);
        frame.pack();
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.convertTemperature();
        }
    }
}