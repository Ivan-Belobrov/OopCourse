package Student4;

import java.util.Scanner;

public class RowNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����������� ����� ����� ���������:");
        int rangeMin = scanner.nextInt();

        System.out.println("������� ������������ ����� ����� ���������:");
        int rangeMax = scanner.nextInt();

        System.out.println("������� ���������� ����� � ������:");
        int rowNumbersCount = scanner.nextInt();

        int i = rangeMin;
        int numbersCount = 0;

        while (i <= rangeMax) {

            System.out.printf("%4d", i);
            numbersCount++;

            if (numbersCount == rowNumbersCount) {
                System.out.println();
                numbersCount = 0;
            }

            i++;
        }
    }
}