package Student8;

import java.util.Scanner;

public class CountingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите любые символы:");
        String line = scanner.nextLine();

        int lettersCount = 0;
        int spacesCount = 0;
        int digitsCount = 0;
        int remainingSymbolsCount = 0;

        for (int i = 0; i < line.length(); ++i) {
            char symbol = line.charAt(i);

            if (Character.isLetter(symbol)) {
                lettersCount++;
            } else if (Character.isWhitespace(symbol)) {
                spacesCount++;
            } else if (Character.isDigit(symbol)) {
                digitsCount++;
            } else {
                remainingSymbolsCount++;
            }
        }

        System.out.println("Количество букв в строке = " + lettersCount);
        System.out.println("Количество пробелов в строке = " + spacesCount);
        System.out.println("Количество цифр в строке = " + digitsCount);
        System.out.println("Количество остальных символов в строке = " + remainingSymbolsCount);
    }
}
