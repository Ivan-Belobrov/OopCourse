package Student11;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int referenceElement = array[(left + right) / 2];

        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < referenceElement) {
                i++;
            }

            while (array[j] > referenceElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(array, left, j);
        }

        if (right > i) {
            quickSort(array, i, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {-2, 40, 8, 7, 8, 1, 10, 3, 0};
        System.out.println("Массив: " + Arrays.toString(array));

        int left = 0;
        int right = array.length - 1;

        quickSort(array, left, right);
        System.out.println("Массив отсортирован 'Быстрой сортировкой': " + Arrays.toString(array));
    }
}