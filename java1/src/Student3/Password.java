package Student3;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "OwenLord";

        System.out.println("������� ������:");
        String userLine = scanner.nextLine();

        int passwordLength = password.length();
        int userLineLength = userLine.length();

        if (password.equals(userLine)) {
            System.out.println("������ ������.");
        } else if (passwordLength > userLineLength) {
            System.out.println("������ ��������, ������ ������� ��������.");
        } else if (passwordLength < userLineLength) {
            System.out.println("������ ��������, ������ ������� �������.");
        } else {
            System.out.println("������ ��������.");
        }
    }
}