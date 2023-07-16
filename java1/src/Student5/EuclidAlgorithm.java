package Student5;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Для того, чтобы найти наибольший общий делитель двух чисел.");

        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();

        if (number1 == 0 && number2 == 0) {
            System.out.println("Ошибка.");
            return;
        }

        while (number2 != 0) {
            int temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }

        System.out.println("НОД = " + number1);
    }
}