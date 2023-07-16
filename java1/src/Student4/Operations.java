package Student4;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double operand2 = scanner.nextDouble();

        System.out.print("Введите число от 1 до 4: ");
        int commandCode = scanner.nextInt();

        switch (commandCode) {
            case 1:
                System.out.println("Результат операции сложение = " + (operand1 + operand2));
                break;
            case 2:
                System.out.println("Результат операции вычитание = " + (operand1 - operand2));
                break;
            case 3:
                System.out.println("Результат операции умножение = " + (operand1 * operand2));
                break;
            case 4:
                System.out.println("Результат операции деление = " + (operand1 / operand2));
                break;
            default:
                System.out.println("Неизвестная операция");
        }
    }
}