package Student8;

import java.util.Scanner;

public class CountingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����� �������:");
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

        System.out.println("���������� ���� � ������ = " + lettersCount);
        System.out.println("���������� �������� � ������ = " + spacesCount);
        System.out.println("���������� ���� � ������ = " + digitsCount);
        System.out.println("���������� ��������� �������� � ������ = " + remainingSymbolsCount);
    }
}
