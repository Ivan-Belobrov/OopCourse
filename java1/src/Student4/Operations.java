package Student4;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ������ �����: ");
        double operand1 = scanner.nextDouble();

        System.out.print("������� ������ �����: ");
        double operand2 = scanner.nextDouble();

        System.out.print("������� ����� �� 1 �� 4: ");
        int commandCode = scanner.nextInt();

        switch (commandCode) {
            case 1:
                System.out.println("��������� �������� �������� = " + (operand1 + operand2));
                break;
            case 2:
                System.out.println("��������� �������� ��������� = " + (operand1 - operand2));
                break;
            case 3:
                System.out.println("��������� �������� ��������� = " + (operand1 * operand2));
                break;
            case 4:
                System.out.println("��������� �������� ������� = " + (operand1 / operand2));
                break;
            default:
                System.out.println("����������� ��������");
        }
    }
}