package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int rows = 10;
    private static final int cols = 10;
    private static final int mines = 10;
    private static final char[][] board = new char[rows][cols];
    private static final boolean[][] minesLocation = new boolean[rows][cols];



    public static void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void initializeMines() {
        Random random = new Random();

        int count = 0;
        while (count < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!minesLocation[row][col]) {
                minesLocation[row][col] = true;
                count++;
            }
        }
    }

    private static void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координаты хода (строка столбец): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (minesLocation[row][col]) {
            System.out.println("Вы проиграли!");
            revealMines();
            System.exit(0);
        } else {
            int count = countAdjacentMines(row, col);
            board[row][col] = (char) (count + '0');
        }
    }

    private static int countAdjacentMines(int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < cols) {
                    if (minesLocation[newRow][newCol]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static void revealMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (minesLocation[i][j]) {
                    board[i][j] = '*';
                }
            }
        }
        printBoard();
    }

    public static void playGame() {
        while (true) {
            printBoard();
            makeMove();
        }
    }
}