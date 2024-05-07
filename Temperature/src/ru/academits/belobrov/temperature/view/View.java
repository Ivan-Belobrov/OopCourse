package ru.academits.belobrov.temperature.view;

import ru.academits.belobrov.temperature.controller.Controller;
import ru.academits.belobrov.temperature.model.Model;
import ru.academits.belobrov.temperature.model.scales.TemperatureScalesManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private final JFrame frame;
    private final JTextField inputField;
    private final JTextField resultTextField;
    private final JComboBox<String> fromScaleComboBox;
    private final JComboBox<String> toScaleComboBox;
    private static final String[] TEMPERATURE_SCALES = TemperatureScalesManager.getTemperatureScaleNames();
    private final Controller controller;

    public View(Model model) {

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
        resultTextField = new JTextField();
        resultTextField.setPreferredSize(new Dimension(200, 10));
        resultTextField.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultTextField);
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

        frame.setSize(400, 210);
        frame.setMinimumSize(new Dimension(400, 210));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        controller = new Controller(this, model);
    }

    public String getInputTemperature() {
        return inputField.getText();
    }

    public String getFromScaleName() {
        return (String) fromScaleComboBox.getSelectedItem();
    }

    public String getToScaleName() {
        return (String) toScaleComboBox.getSelectedItem();
    }

    public void setResult(String result) {
        resultTextField.setText(result);
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

    public void clearInputField() {
        inputField.setText("");

    }
}