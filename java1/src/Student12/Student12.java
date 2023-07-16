package Student12;

import java.util.Arrays;

public class Student12 {
    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i);
        }

        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, 0);
        }
    }

    public static void heapify(int[] array, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        while (leftChild < array.length || rightChild < array.length) {
            if (leftChild < array.length && array[leftChild] > array[largest]) {
                largest = leftChild;
            }

            if (rightChild < array.length && array[rightChild] > array[largest]) {
                largest = rightChild;
            }

            if (largest != i) {
                int temp = array[0];
                array[0] = array[largest];
                array[largest] = temp;
                i = largest;

                leftChild = 2 * i + 1;
                rightChild = 2 * i + 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 3, 6, 8, 7, 1, 12};
        System.out.println(Arrays.toString(array));

        heapSort(array);
        System.out.println("Массив отсортирован 'Пирамидальной сортировкой': " + Arrays.toString(array));
    }
}