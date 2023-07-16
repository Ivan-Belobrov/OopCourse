package Student5;

import java.util.Scanner;

public class NOD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ����� �����: ");
        int number1 = scanner.nextInt();

        System.out.print("������� ����� �����: ");
        int number2 = scanner.nextInt();

        if (number1 <= 0 && number2 <= 0) {
            System.out.println("������.");
            return;
        }

        while (number1 > 0 || number2 > 0) {
            number2 = number1 % number2;

            if (number2 > 0) {
                number2 %= number1;
            } else {
                System.out.println("��� = " + number2);
            }

        }
    }
}