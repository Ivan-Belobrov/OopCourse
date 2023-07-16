package Student11;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 2, 8, 4, 6, 7};
        System.out.println("Массив: " + Arrays.toString(array));

        selectionSort(array);
        System.out.println("Массив отсортирован 'Сортировкой выбором': " + Arrays.toString(array));
    }
}