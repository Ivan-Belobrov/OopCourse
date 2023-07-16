package Student4;

import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int numbersCountInRow = scanner.nextInt();

        int sum = 0;
        int i = 1;

        while (i <= numbersCountInRow) {

            if (i % 2 == 0) {
                sum -= Math.pow(i, 2);
            } else {
                sum += Math.pow(i, 2);
            }

            i++;
        }

        System.out.println("Сумма ряда = " + sum);
    }
}