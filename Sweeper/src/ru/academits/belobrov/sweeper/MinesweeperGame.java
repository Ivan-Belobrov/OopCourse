package ru.academits.belobrov.sweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinesweeperGame extends JFrame {
    private JButton[][] buttons;
    private int[][] board;
    private final int size;
    private final int numMines;
    private int numUnopenedCells;
    private final List<Integer> highScores;
    private ImageIcon bombIcon;
    private final Timer timer;
    private long startTime;
    private final JButton timerButton;
    private int flaggedCells;
    private ImageIcon flagIcon;

    public MinesweeperGame(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.numUnopenedCells = size * size;
        this.highScores = new ArrayList<>();
        this.bombIcon = new ImageIcon("bomb1.jpg");
        Image imageBomb = bombIcon.getImage();
        Image scaledImageBomb = imageBomb.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        this.bombIcon = new ImageIcon(scaledImageBomb);
        this.timer = new Timer(1000, new TimerListener());
        this.flagIcon = new ImageIcon("флаг.jpg");
        Image image = flagIcon.getImage();
        Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        this.flagIcon = new ImageIcon(scaledImage);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Сапер");
        setResizable(false);
        setLocationRelativeTo(null);

        createButtons();
        createBoard();

        JButton restartButton = new JButton("Начать игру заново");
        restartButton.addActionListener(e -> restartGame());

        JButton highScoresButton = new JButton("Рекорды");
        highScoresButton.addActionListener(e -> showHighScores());

        JButton rulesButton = new JButton("Правила игры");
        rulesButton.addActionListener(e -> showGameRules());

        timerButton = new JButton("0 сек");
        timerButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(highScoresButton);
        buttonPanel.add(restartButton);
        buttonPanel.add(rulesButton);
        buttonPanel.add(timerButton);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(createBoardPanel(), BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(createBoardPanel(), BorderLayout.CENTER);

        add(mainPanel);
        pack();
        setVisible(true);
    }

    private void createButtons() {
        buttons = new JButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addMouseListener(new MouseClickListener(i, j));
                buttons[i][j].setPreferredSize(new Dimension(30, 30));
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 10));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
            }
        }
    }

    private JPanel createBoardPanel() {
        JPanel boardPanel = new JPanel(new GridLayout(size, size, 2, 2));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardPanel.add(buttons[i][j]);
            }
        }

        boardPanel.setPreferredSize(new Dimension(size * 30, size * 30));

        return boardPanel;
    }

    private void createBoard() {
        board = new int[size][size];
        int count = 0;

        while (count < numMines) {
            int row = (int) (Math.random() * size);
            int col = (int) (Math.random() * size);

            if (board[row][col] != -1) {
                board[row][col] = -1;
                count++;
            }
        }
    }

    private void restartGame() {
        numUnopenedCells = size * size;
        timer.stop();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setBackground(Color.GRAY);
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText("");
                buttons[i][j].setIcon(null);
            }
        }

        createBoard();
    }

    private void revealCell(int row, int col) {
        if (board[row][col] == -1) {
            buttons[row][col].setBackground(Color.RED);
            buttons[row][col].setIcon(bombIcon);
            gameOver();
        } else {
            int numAdjacentMines = countAdjacentMines(row, col);
            buttons[row][col].setBackground(Color.WHITE);
            buttons[row][col].setEnabled(false);
            buttons[row][col].setText(String.valueOf(numAdjacentMines));
            numUnopenedCells--;

            if (numUnopenedCells == numMines) {
                gameWon();
            } else if (numAdjacentMines == 0) {
                revealAdjacentCells(row, col);
            }
        }
    }

    private void revealAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j) && buttons[i][j].isEnabled()) {
                    revealCell(i, j);
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j) && board[i][j] == -1) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private void gameOver() {
        timer.stop();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == -1) {
                    buttons[i][j].setIcon(bombIcon);
                }

                buttons[i][j].setEnabled(false);
            }
        }

        JOptionPane.showMessageDialog(this, "Вы проиграли!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void gameWon() {
        timer.stop();
        int score = size * size - numMines;
        highScores.add(score);
        Collections.sort(highScores);

        if (highScores.size() > 10) {
            highScores.remove(10);
        }

        JOptionPane.showMessageDialog(this, "Ваш результат: " + score, "Победа!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showHighScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Рекорды:" + System.lineSeparator());

        for (int i = 0; i < highScores.size(); i++) {
            sb.append(i + 1).append(". ").append(highScores.get(i)).append(System.lineSeparator());
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Рекорды", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGameRules() {
        String rules = """
                Правила игры Сапер:

                Цель игры: Открывайте ячейки на игровом поле и избегайте взрыва мин.
                Если открываете ячейку с миной, игра проиграна.
                Если открываете ячейку без мины, в ячейке отображается число мин вокруг нее.
                Цель игры - открыть все ячейки без мин.

                Управление:
                Левый клик мыши - открыть ячейку.
                Правый клик мыши - пометить ячейку как возможную мину.

                Удачи!""";
        JOptionPane.showMessageDialog(this, rules, "Правила игры", JOptionPane.INFORMATION_MESSAGE);
    }

    private class ButtonClickListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (!timer.isRunning()) {
                startTime = System.currentTimeMillis();
                timer.start();
            }

            revealCell(row, col);
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long seconds = elapsedTime / 1000;
            timerButton.setText(seconds + " сек");
        }
    }

    private class MouseClickListener extends MouseAdapter {
        private final int row;
        private final int col;

        public MouseClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                if (buttons[row][col].isEnabled()) {
                    if (buttons[row][col].getIcon() == null && flaggedCells < numMines) {
                        buttons[row][col].setIcon(flagIcon);
                        flaggedCells++;
                    } else if (buttons[row][col].getIcon() != null) {
                        buttons[row][col].setIcon(null);
                        flaggedCells--;
                    }
                }
            }
        }
    }
}