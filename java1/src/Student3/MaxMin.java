package Student3;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ââåäèòå ïåğâîå ÷èñëî: ");
        int number1 = scanner.nextInt();

        System.out.print("Ââåäèòå âòîğîå ÷èñëî: ");
        int number2 = scanner.nextInt();

        if (number1 > number2) {
            System.out.println("max = " + number1);
            System.out.println("min = " + number2);
        } else {
            System.out.println("max = " + number2);
            System.out.println("min = " + number1);
        }

        int max = (number1 > number2) ? number1 : number2;
        int min = (number1 < number2) ? number1 : number2;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}