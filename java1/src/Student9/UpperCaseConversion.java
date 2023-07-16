package Student9;

import java.util.Arrays;

public class UpperCaseConversion {
    public static void convertToUpperCase(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toUpperCase();
        }
    }

    public static void main(String[] args) {
        String[] array = {"hello World", "Привет", "Пока"};
        convertToUpperCase(array);
        System.out.println("Перевод строки в верхний регистр: " + Arrays.toString(array));
    }
}