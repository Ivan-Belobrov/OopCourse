package Student11;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            for (; j >= 0; j--) {

                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }

            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 4, 8, 10, 7, 12};
        System.out.println("Массив: " + Arrays.toString(array));

        insertionSort(array);
        System.out.println("Массив отсортирован 'Сортировкой вставками': " + Arrays.toString(array));
    }
}