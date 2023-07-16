package Student3;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����������� ����.");

        System.out.print("����: ");
        int day = scanner.nextInt();

        System.out.print("�����: ");
        int month = scanner.nextInt();

        System.out.print("���: ");
        int year = scanner.nextInt();

        if (month > 12 || month <= 0 || year <= 0) {
            System.out.print("���� ������� �����������.");
            return;
        }

        int lastDayInMonth;

        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);

            if (isLeapYear) {
                lastDayInMonth = 29;
            } else {
                lastDayInMonth = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            lastDayInMonth = 30;
        } else {
            lastDayInMonth = 31;
        }

        System.out.println();

        int newDay = day;
        int newMonth = month;

        if (day <= 0 || day > lastDayInMonth) {
            System.out.print("���� ������� �����������.");
        } else if (day == lastDayInMonth && month == 12) {
            newDay = 1;
            newMonth = 1;
            int newYear = year + 1;

            System.out.printf("������� ����: %02d.%02d.%04d", newDay, newMonth, newYear);
        } else if (day == lastDayInMonth) {
            newDay = 1;
            newMonth++;

            System.out.printf("������� ����: %02d.%02d.%04d", newDay, newMonth, year);
        } else {
            newDay++;

            System.out.printf("������� ����: %02d.%02d.%04d", newDay, month, year);
        }
    }
}