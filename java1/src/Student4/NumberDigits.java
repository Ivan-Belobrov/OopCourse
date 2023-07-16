package Student4;

import java.util.Scanner;

public class NumberDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        int digitsSum = 0;
        int oddDigitsSum = 0;
        int maxDigit = 0;

        while (number != 0) {
            int currentDigit = number % 10;

            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }

            digitsSum += currentDigit;

            if (currentDigit % 2 != 0) {
                oddDigitsSum += currentDigit;
            }

            number /= 10;
        }

        System.out.println("Сумма всех цифр числа = " + digitsSum);
        System.out.println("Сумма всех нечетных цифр числа = " + oddDigitsSum);
        System.out.println("Максимальная цифра числа  = " + maxDigit);
    }
}