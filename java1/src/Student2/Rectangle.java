package Student2;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размеры прямоугольника!");

        System.out.print("Длина прямоугольника = ");
        double rectangleLength = scanner.nextDouble();

        System.out.print("Ширина прямоугольника = ");
        double rectangleWidth = scanner.nextDouble();

        double rectangleArea = rectangleLength * rectangleWidth;
        double rectanglePerimeter = (rectangleLength + rectangleWidth) * 2;
        System.out.printf("Площадь прямоугольника = %.2f! Периметр прямоугольника = %.2f!", rectangleArea, rectanglePerimeter);
    }
}
