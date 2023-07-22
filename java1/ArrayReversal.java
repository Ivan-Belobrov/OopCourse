package java1;

import java.util.Arrays;

public class ArrayReversal {
    public static void revertArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 2, 0, 4, 6, 7};
        System.out.println("Массив: " + Arrays.toString(array));

        revertArray(array);
        System.out.println("Перевернутый массив: " + Arrays.toString(array));
    }
}