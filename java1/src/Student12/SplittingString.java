package Student12;

public class SplittingString {
    public static void main(String[] args) {
        String numbersLine = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        String[] numbers = numbersLine.split(", ");

        int[] splittingString = new int[numbers.length];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            splittingString[i] = Integer.parseInt(numbers[i]);
            sum += splittingString[i];
        }

        System.out.println("Сумма чисел строки = " + sum);
    }
}
