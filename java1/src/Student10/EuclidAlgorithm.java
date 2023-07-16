package Student10;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static int getGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }

        return getGreatestCommonDivisor(number2, number1 % number2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("��� ����, ����� ����� ���������� ����� �������� ���� �����.");

        System.out.print("������� ������ ����� �����: ");
        int number1 = scanner.nextInt();

        System.out.print("������� ������ ����� �����: ");
        int number2 = scanner.nextInt();

        if (number1 == 0 && number2 == 0) {
            System.out.println("������.");
            return;
        }

        System.out.printf("��� = %d%n", getGreatestCommonDivisor(number1, number2));
    }
}