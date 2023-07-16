package Student9;

import java.util.Scanner;

public class MultiplicationTable {
    public static int[][] getMultiplicationTable(int rowCount, int columnCount) {
        int[][] table = new int[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¬ведите количество строк таблицы умножени€: ");
        int rowsCount = scanner.nextInt();

        System.out.print("¬ведите количество столбцов таблицы умножени€: ");
        int columnsCount = scanner.nextInt();

        int[][] multiplicationTable = getMultiplicationTable(rowsCount, columnsCount);

        System.out.print("     |");

        for (int i = 1; i <= multiplicationTable[0].length; i++) {
            System.out.printf("%4d", i);
        }

        System.out.println();
        System.out.print("   ___");

        String horizontalLine = "__";

        for (int i = 1; i <= multiplicationTable[0].length; i++) {
            System.out.printf("%4s", horizontalLine);
        }

        System.out.println();

        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.printf("%4d |", i + 1);

            for (int j = 0; j < multiplicationTable[i].length; j++) {
                System.out.printf("%4d", multiplicationTable[i][j]);
            }

            System.out.println();
        }
    }
}