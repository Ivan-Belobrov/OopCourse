package Student5;

import java.util.Scanner;

public class InputAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "Owen";

        System.out.println("������� ������:");

        while (true) {
            String inputLine = scanner.nextLine();

            if (password.equals(inputLine)) {
                System.out.println("������ ������.");
                break;
            }

            System.out.println("������ ��������.");
            System.out.println("���������� ������ ������:");
        }
    }
}