package Student4;

import java.util.Scanner;

public class NameTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название команды:");
        String name = scanner.nextLine();

        switch (name) {
            case "print":

                String name1 = scanner.nextLine();

                System.out.println(name1);
                break;
            case "sum":

                System.out.print("Введите число:");
                double number1 = scanner.nextDouble();

                System.out.print("Введите число:");
                double number2 = scanner.nextDouble();

                System.out.println("Результат = "+ (number1 + number2));
                break;
            default:
                System.out.println("Неизвестная команда");
                break;
        }
    }
}
