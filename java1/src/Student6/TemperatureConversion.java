package Student6;

import java.util.Scanner;

public class TemperatureConversion {//�����
    public static double getKelvinTemperature(double celsiusDegrees) {

        return celsiusDegrees + 273.15;
    }

    public static double getFahrenheitTemperature(double celsiusDegrees) {

        return (celsiusDegrees * 1.8) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("������� ����������� �� ����� ������� = ");
        double celsiusDegrees = scanner.nextDouble();

        System.out.println("�������� �� ����� �������� = " + getKelvinTemperature(celsiusDegrees));
        System.out.println("�������� �� ����� ���������� = " + getFahrenheitTemperature(celsiusDegrees));
    }
}
