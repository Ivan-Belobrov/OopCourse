package Student12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrences {
    public static int countOccurrences(String fileName, String searchString) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                count += countOccurrencesInLine(line.toLowerCase(), searchString);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        return count;
    }

    public static int countOccurrencesInLine(String line, String searchString) {
        int count = 0;
        int index = 0;

        while ((index = line.indexOf(searchString, index)) != -1) {
            count++;
            index += searchString.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String fileName = "text.txt";
        String searchString = "World";

        searchString = searchString.toLowerCase();
        System.out.println("Количество вхождений = " + countOccurrences(fileName, searchString));
    }
}