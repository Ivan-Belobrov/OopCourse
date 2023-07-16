package Student5;

import java.util.Scanner;

public class InputAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "Owen";

        System.out.println("Введите пароль:");

        while (true) {
            String inputLine = scanner.nextLine();

            if (password.equals(inputLine)) {
                System.out.println("Пароль верный.");
                break;
            }

            System.out.println("Пароль неверный.");
            System.out.println("Попробуйте ввести заново:");
        }
    }
}