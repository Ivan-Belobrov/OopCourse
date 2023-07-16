package Student5;

import java.util.Scanner;

public class Contribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ����� ������: ");
        double contribution = scanner.nextDouble();

        System.out.print("���������� �������: ");
        int monthsCount = scanner.nextInt();

        System.out.print("���������� ������: ");
        double interestRate = scanner.nextDouble();

        final double hundredPercent = 100;
        final int monthsInYearCount = 12;

        double percent = interestRate / hundredPercent / monthsInYearCount;
        double newContribution = contribution;

        for (int i = 0; i < monthsCount; ++i) {
            newContribution += newContribution * percent;
        }

        double profit = newContribution - contribution;

        System.out.println("������� �� ������ " + profit + " ������");
        System.out.println("����� ������ � ���������� " + newContribution + " ������");
    }
}