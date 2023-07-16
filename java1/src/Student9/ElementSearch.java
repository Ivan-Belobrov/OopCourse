package Student9;

public class ElementSearch {
    public static int getArrayElementIndex(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 6, 8, 10, 22, 25, 10, 30};
        int number = 22;
        int numberIndex = getArrayElementIndex(array, number);

        if (numberIndex != -1) {
            System.out.printf("Индекс числа %d = %d", number, numberIndex);
        } else {
            System.out.printf("Данное число %d не найдено, индекс = %d", number, numberIndex);
        }
    }
}