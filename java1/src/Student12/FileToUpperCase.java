package Student12;

import java.io.*;

public class FileToUpperCase {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             PrintWriter writer = new PrintWriter("output.txt")) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.println(line.toUpperCase());
            }

            System.out.println("���� ��������� � ������� �������!");
        } catch (IOException e) {
            System.out.println("������: " + e.getMessage());
        }
    }
}