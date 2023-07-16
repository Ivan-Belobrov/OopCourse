package Student3;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "OwenLord";

        System.out.println("Введите пароль:");
        String userLine = scanner.nextLine();

        int passwordLength = password.length();
        int userLineLength = userLine.length();

        if (password.equals(userLine)) {
            System.out.println("Пароль верный.");
        } else if (passwordLength > userLineLength) {
            System.out.println("Пароль неверный, строка слишком короткая.");
        } else if (passwordLength < userLineLength) {
            System.out.println("Пароль неверный, строка слишком длинная.");
        } else {
            System.out.println("Пароль неверный.");
        }
    }
}