package Student2;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ������� ��������������!");

        System.out.print("����� �������������� = ");
        double rectangleLength = scanner.nextDouble();

        System.out.print("������ �������������� = ");
        double rectangleWidth = scanner.nextDouble();

        double rectangleArea = rectangleLength * rectangleWidth;
        double rectanglePerimeter = (rectangleLength + rectangleWidth) * 2;
        System.out.printf("������� �������������� = %.2f! �������� �������������� = %.2f!", rectangleArea, rectanglePerimeter);
    }
}
