package Student3;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ��� �������: ");
        int age = scanner.nextInt();

        int ageLastDigit = age % 10;
        int ageLastTwoDigits = age % 100;

        if (age <= 0) {
            System.out.println("�� ������� ����.");
        } else if (age > 112) {
            System.out.println("�� ������� �����.");
        } else if ((ageLastTwoDigits > 10 && ageLastTwoDigits <= 14) || ageLastDigit == 0 || ageLastDigit >= 5) {
            System.out.printf("��� %d ���", age);
        } else if (ageLastDigit > 1) {
            System.out.printf("��� %d ����", age);
        } else {
            System.out.printf("��� %d ���", age);
        }
    }
}