package Student9;

public class ArrayEvenNumbersArithmeticMean {
    public static void main(String[] args) {
        int[] array = {1, 5, 6, 8, 7, 9, 7, 10, 2, 2, 4};
        System.out.println("Среднее арифметическое четных чисел массива = " + getArrayEvenNumbersArithmeticMean(array));
    }

    public static double getArrayEvenNumbersArithmeticMean(int[] numbersArray) {
        int sum = 0;
        int count = 0;

        for (int e : numbersArray) {

            if (e % 2 == 0) {
                sum += e;
                count++;
            }
        }

        return (double) sum / count;
    }
}