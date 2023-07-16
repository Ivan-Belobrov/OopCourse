package Student4;

public class ArithmeticMeanDoWhile {
    public static void main(String[] args) {
        int i = 3;
        int endNumber = 17;

        int numbersSum = 0;
        int numbersCount = 0;

        int evenNumbersSum = 0;
        int evenNumbersCount = 0;

        do {
            numbersSum += i;
            ++numbersCount;

            if (i % 2 == 0) {
                evenNumbersSum += i;
                ++evenNumbersCount;
            }

            ++i;
        } while (i <= endNumber);

        double numbersArithmeticMean = (double) numbersSum / numbersCount;
        double evenNumbersArithmeticMean = (double) evenNumbersSum / evenNumbersCount;

        System.out.println("����� ���� ����� = " + numbersSum);
        System.out.println("���������� ���� ����� = " + numbersCount);
        System.out.println("������� �������������� ����� = " + numbersArithmeticMean);
        System.out.println();
        System.out.println("����� ������ ����� = " + evenNumbersSum);
        System.out.println("���������� ������ ����� = " + evenNumbersCount);
        System.out.println("������� �������������� ������ ����� = " + evenNumbersArithmeticMean);
    }
}