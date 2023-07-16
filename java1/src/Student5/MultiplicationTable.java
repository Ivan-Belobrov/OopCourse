package Student5;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите максимальное число таблицы умножени€: ");

        int tableSize = scanner.nextInt();

        int[][] multiplicationTable = new int[tableSize][tableSize];

        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.print("     |");

        for (int i = 1; i <= tableSize; i++) {
            System.out.printf("%4d", i);
        }

        System.out.println();
        System.out.print("   ___");

        String horizontalLine = "__";

        for (int i = 1; i <= tableSize; i++) {
            System.out.printf("%4s", horizontalLine);
        }

        System.out.println();

        for (int i = 0; i < tableSize; i++) {
            System.out.printf("%4d |", i + 1);

            for (int j = 0; j < tableSize; j++) {
                System.out.printf("%4d", multiplicationTable[i][j]);
            }

            System.out.println();
        }
    }
}