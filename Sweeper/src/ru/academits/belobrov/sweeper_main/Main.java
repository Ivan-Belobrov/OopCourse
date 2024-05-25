package ru.academits.belobrov.sweeper_main;

import ru.academits.belobrov.sweeper.MinesweeperGame;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] difficulties = {"Легко", "Средне", "Тяжело"};
                JComboBox<String> difficultyComboBox = new JComboBox<>(difficulties);
                JOptionPane.showMessageDialog(null, difficultyComboBox, "Выберите сложность игры.", JOptionPane.PLAIN_MESSAGE);

                int size;
                String selectedDifficulty = (String) difficultyComboBox.getSelectedItem();

                if (Objects.equals(selectedDifficulty, "Легко")) {
                    size = 8;
                } else if (Objects.requireNonNull(selectedDifficulty).equalsIgnoreCase("Средне")) {
                    size = 12;
                } else {
                    size = 16;
                }

                new MinesweeperGame(size, size);
            }
        });
    }
}