package Student10;

public class BinarySearch {
    public static int binarySearchRecursive(int[] array, int left, int right, int number) {
        if (left > right) {
            return -1;
        }

        int middle = (right + left) / 2;

        if (array[middle] < number) {
            return binarySearchRecursive(array, middle + 1, right, number);
        }

        if (array[middle] > number) {
            return binarySearchRecursive(array, left, middle - 1, number);
        }

        return middle;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 5, 8, 9, 10, 15};
        int number = 7;

        System.out.printf("Бинарный поиск с рекурсией Index = %d%n", binarySearchRecursive(array, 0, array.length - 1, number));
        System.out.printf("Бинарный поиск без рекурсии Index = %d%n", binarySearch(array, number));
    }

    public static int binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (array[middle] == number) {
                return middle;
            }

            if (array[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}