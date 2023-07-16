package Student4;

public class ArithmeticMean {
    public static void main(String[] args) {
        int i = 3;
        int endNumber = 17;

        int numbersSum = 0;
        int numbersCount = 0;

        int evenNumbersSum = 0;
        int evenNumbersCount = 0;

        while (i <= endNumber) {
            numbersSum += i;
            ++numbersCount;

            if (i % 2 == 0) {
                evenNumbersSum += i;
                ++evenNumbersCount;
            }

            ++i;
        }

        double numbersArithmeticMean = (double) numbersSum / numbersCount;
        double evenNumbersArithmeticMean = (double) evenNumbersSum / evenNumbersCount;

        System.out.println("Сумма всех чисел = " + numbersSum);
        System.out.println("Количество этих чисел = " + numbersCount);
        System.out.println("Среднее арифметическое чисел = " + numbersArithmeticMean);
        System.out.println();
        System.out.println("Сумма четных чисел = " + evenNumbersSum);
        System.out.println("Количество четных чисел = " + evenNumbersCount);
        System.out.println("Среднее арифметическое четных чисел = " + evenNumbersArithmeticMean);
    }
}