package Student10;

import java.util.Scanner;

public class Exponentiation {
    public static int raiseToPowerWithRecursion(int number, int power) {
        if (power == 0) {
            return 1;
        }

        return raiseToPowerWithRecursion(number, power - 1) * number;
    }

    public static int raiseToPower(int number, int power) {
        int result = 1;

        for (int i = 0; i < power; i++) {
            result *= number;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� �����: ");
        int number = scanner.nextInt();

        System.out.print("������� ������� �����: ");
        int power = scanner.nextInt();

        System.out.printf("���������� ����� � ������� %d^%d = %d%n", number, power, raiseToPower(number, power));
        System.out.printf("���������� ����� � ������� � ������� �������� %d^%d = %d%n", number, power, raiseToPowerWithRecursion(number, power));
    }
}