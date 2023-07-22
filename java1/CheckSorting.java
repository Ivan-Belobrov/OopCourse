package java1;

public class CheckSorting {
    public static boolean isSortedDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSortedAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 2, 3, 4, 5};
        System.out.println("Массив отсортирован по возрастанию: " + isSortedAscending(array1));

        int[] array2 = {3, 4, 3, 2, 1};
        System.out.println("Массив отсортирован по убыванию: " + isSortedDescending(array2));
    }
}