package Student5;

import java.util.Scanner;

public class Contribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        double contribution = scanner.nextDouble();

        System.out.print("Количество месяцев: ");
        int monthsCount = scanner.nextInt();

        System.out.print("Процентная ставка: ");
        double interestRate = scanner.nextDouble();

        final double hundredPercent = 100;
        final int monthsInYearCount = 12;

        double percent = interestRate / hundredPercent / monthsInYearCount;
        double newContribution = contribution;

        for (int i = 0; i < monthsCount; ++i) {
            newContribution += newContribution * percent;
        }

        double profit = newContribution - contribution;

        System.out.println("Прибыль от вклада " + profit + " рублей");
        System.out.println("Сумма вклада с процентами " + newContribution + " рублей");
    }
}