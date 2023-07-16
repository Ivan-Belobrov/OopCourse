package Student11;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean isSwapped = false;

            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 4, 2, 3, 8, 10};
        System.out.println("Массив: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Массив отсортирован 'Сортировкой пузырьком': " + Arrays.toString(array));
    }
}