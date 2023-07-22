package java1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrences {
    public static int countOccurrences(String fileName, String searchString) throws IOException {
        int count = 0;
        searchString = searchString.toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                int index = line.indexOf(searchString);

                while (index != -1) {
                    count++;
                    index = line.indexOf(searchString, index + searchString.length());
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String fileName = "text.txt";
        String searchString = "World";

        try {
            System.out.println("Количество вхождений = " + countOccurrences(fileName, searchString));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}