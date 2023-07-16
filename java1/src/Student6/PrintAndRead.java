package Student6;

import java.util.Scanner;

public class PrintAndRead {
    public static int printAndRead(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int number = printAndRead("������� �����: ");
        System.out.println("�� ����� ����� " + number);

        System.out.println();

        int stringLength = printAndRead("������� ����� ������: ");
        System.out.println("����� ������ = " + stringLength);
    }
}