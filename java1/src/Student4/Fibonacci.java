package Student4;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер Числа Фибоначчи: ");
        int fibonacciNumberIndex = scanner.nextInt();

        int previousFibonacciNumber = 0;
        int currentFibonacciNumber = 1;

        int i = 0;

        while (i < fibonacciNumberIndex) {
            int fibonacciNumbersSum = currentFibonacciNumber + previousFibonacciNumber;
            previousFibonacciNumber = currentFibonacciNumber;
            currentFibonacciNumber = fibonacciNumbersSum;

            i++;
        }

        System.out.printf("Число Фибоначчи %d = %d", fibonacciNumberIndex, previousFibonacciNumber);
    }
}