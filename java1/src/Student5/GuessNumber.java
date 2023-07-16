package Student5;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        System.out.println("������, �� ������ ������� � ����?");
        System.out.print("�����: ");
        String name = scanner.nextLine();

        String no = "���";

        if (name.equals(no)) {
            System.out.println("����...");
            System.out.println("� ��������, ��� �� �� ���� ���������.");
            return;
        }

        System.out.println();
        System.out.println("� ���� �� �������� ��������.");
        System.out.println();
        System.out.println("������� ����:");
        System.out.println("� ������� ��������� ����� �� 1 �� 100 ������������.");
        System.out.println("���� ������ �������� ��� �����.");
        System.out.println("P.S. ���������� ������� �� �����������.");
        System.out.println();
        System.out.println("������� ����� �����:");

        int attemptsCount = 0;

        while (true) {
            attemptsCount++;

            int inputNumber = scanner.nextInt();

            if (randomNumber > inputNumber) {
                System.out.println("����� ������ �����������.");
            } else if (randomNumber < inputNumber) {
                System.out.println("����� ������ �����������.");
            } else {
                System.out.println("���. �� �������� �����.");
                break;
            }

            System.out.println("������� ����� ������:");
        }

        System.out.printf("�� ������������ %d �������.", attemptsCount);
    }
}