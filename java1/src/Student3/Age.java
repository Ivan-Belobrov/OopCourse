package Student3;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        int ageLastDigit = age % 10;
        int ageLastTwoDigits = age % 100;

        if (age <= 0) {
            System.out.println("Вы слишком малы.");
        } else if (age > 112) {
            System.out.println("Вы слишком стары.");
        } else if ((ageLastTwoDigits > 10 && ageLastTwoDigits <= 14) || ageLastDigit == 0 || ageLastDigit >= 5) {
            System.out.printf("Вам %d Лет", age);
        } else if (ageLastDigit > 1) {
            System.out.printf("Вам %d Года", age);
        } else {
            System.out.printf("Вам %d Год", age);
        }
    }
}