package Student3;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double epsilon = 1.0e-10;

        System.out.println("������� �����:");

        System.out.print("a = ");
        double a = scanner.nextDouble();

        System.out.print("b = ");
        double b = scanner.nextDouble();

        System.out.print("c = ");
        double c = scanner.nextDouble();

        if (Math.abs(a) <= epsilon) {
            if (Math.abs(b) <= epsilon) {
                if (Math.abs(c) <= epsilon) {
                    System.out.println("����������� ���������� �������.");
                } else {
                    System.out.println("��� �������.");
                }
            } else {
                double x = -c / b;
                System.out.println("���� ������: " + x);
            }
        } else {
            double discriminant = Math.pow(b, 2) - (4 * a * c);
            System.out.println(" ������������ = " + discriminant);

            if (discriminant < -epsilon) {
                System.out.print("������������ ������ 0, ������ ���.");
            } else if (Math.abs(discriminant) <= epsilon) {
                double root = -b / (2 * a);
                System.out.printf("������������ ����� 0, ��������� ����� ���� ������: x1 = %f", root);
            } else {
                double discriminantRoot = Math.sqrt(discriminant);
                double root1 = (-b + discriminantRoot) / (2 * a);
                double root2 = (-b - discriminantRoot) / (2 * a);
                System.out.printf("������������ ������ 0, ��������� ����� ��� �����: x1 = %f ; x2 = %f", root1, root2);
            }
        }
    }
}