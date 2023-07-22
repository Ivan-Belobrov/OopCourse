package java1;

public class StringSplitting {
    public static void main(String[] args) {
        String numbersString = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        String[] arrayStrings = numbersString.split(", ");

        int[] numbersArray = new int[arrayStrings.length];
        int sum = 0;

        for (int i = 0; i < arrayStrings.length; i++) {
            numbersArray[i] = Integer.parseInt(arrayStrings[i]);
            sum += numbersArray[i];
        }

        System.out.println("Сумма чисел строки = " + sum);
    }
}
