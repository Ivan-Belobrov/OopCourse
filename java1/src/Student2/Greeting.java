package Student2;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ���� ���:");
        String name = scanner.nextLine();

        System.out.println("������, " + name + "!");
    }
}