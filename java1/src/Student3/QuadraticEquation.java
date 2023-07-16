package Student3;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double epsilon = 1.0e-10;

        System.out.println("Введите число:");

        System.out.print("a = ");
        double a = scanner.nextDouble();

        System.out.print("b = ");
        double b = scanner.nextDouble();

        System.out.print("c = ");
        double c = scanner.nextDouble();

        if (Math.abs(a) <= epsilon) {
            if (Math.abs(b) <= epsilon) {
                if (Math.abs(c) <= epsilon) {
                    System.out.println("Бесконечное количество решений.");
                } else {
                    System.out.println("Нет решения.");
                }
            } else {
                double x = -c / b;
                System.out.println("Один корень: " + x);
            }
        } else {
            double discriminant = Math.pow(b, 2) - (4 * a * c);
            System.out.println(" Дискриминант = " + discriminant);

            if (discriminant < -epsilon) {
                System.out.print("Дискриминант меньше 0, корней нет.");
            } else if (Math.abs(discriminant) <= epsilon) {
                double root = -b / (2 * a);
                System.out.printf("Дискриминант равен 0, уравнение имеет один корень: x1 = %f", root);
            } else {
                double discriminantRoot = Math.sqrt(discriminant);
                double root1 = (-b + discriminantRoot) / (2 * a);
                double root2 = (-b - discriminantRoot) / (2 * a);
                System.out.printf("Дискриминант больше 0, уравнение имеет два корня: x1 = %f ; x2 = %f", root1, root2);
            }
        }
    }
}