package Student11;

public class SortingChoice {
    public static int getIndexMinimalNumber(int[] array, int startIndex) {
        int maxNumberArray = 0;
        int indexMinimalNumber = 0;

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] > maxNumberArray) {
                maxNumberArray = array[i];
            }
        }

        int minNumberArray = maxNumberArray;

        for (int j = startIndex; j < array.length; j++) {
            if (array[j] < minNumberArray) {
                minNumberArray = array[j];
                indexMinimalNumber = j;
            }
        }

        return indexMinimalNumber;
    }

    public static void main(String[] args) {
        int[] array = {12, 1, 5, 7, 5, 17, 3, 2, 1};
        int startIndex = 5;
        System.out.print("Индекс минимального числа = " + getIndexMinimalNumber(array, startIndex));
    }
}