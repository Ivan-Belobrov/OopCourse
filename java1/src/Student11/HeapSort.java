package Student11;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            siftDown(array, i, 0);
        }
    }

    public static void siftDown(int[] array, int arrayLength, int i) {
        while (true) {
            int maxIndex = i;
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            if (leftChildIndex < arrayLength && array[leftChildIndex] > array[maxIndex]) {
                maxIndex = leftChildIndex;
            }

            if (rightChildIndex < arrayLength && array[rightChildIndex] > array[maxIndex]) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == i) {
                return;
            }

            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;

            i = maxIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 3, 6, 8, 7, 1, 12};
        System.out.println(Arrays.toString(array));

        heapSort(array);
        System.out.println("Массив отсортирован 'Пирамидальной сортировкой': " + Arrays.toString(array));
    }
}