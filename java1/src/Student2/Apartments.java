package Student2;

import java.util.Scanner;

public class Apartments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ����� ��������: ");
        int apartmentNumber = scanner.nextInt();

        System.out.print("������� ���������� ���������: ");
        int entrancesCount = scanner.nextInt();

        System.out.print("������� ���������� ������: ");
        int levelsCount = scanner.nextInt();

        int apartmentsCountOnLevel = 4;
        int apartmentsCountInEntrance = levelsCount * apartmentsCountOnLevel;
        int apartmentsCountHouse = entrancesCount * apartmentsCountInEntrance;

        if (apartmentNumber <= 0 || apartmentNumber > apartmentsCountHouse) {
            System.out.println("�������� � ����� ������� ��� � ����");
            return;
        }

        int entranceNumber = (apartmentNumber - 1) / apartmentsCountInEntrance + 1;
        int levelNumber = (apartmentNumber - apartmentsCountInEntrance * (entranceNumber - 1) - 1) / apartmentsCountOnLevel + 1;

        System.out.println(entranceNumber + " �������");
        System.out.println(levelNumber + " ����");

        int apartmentLocation = apartmentNumber % apartmentsCountOnLevel;

        if (apartmentLocation == 1) {
            System.out.println("�������� ����� �������");
        } else if (apartmentLocation == 2) {
            System.out.println("�������� ����� �������");
        } else if (apartmentLocation == 3) {
            System.out.println("�������� ������ �������");
        } else {
            System.out.println("�������� ������ �������");
        }
    }
}