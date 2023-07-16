package Student6;

import java.util.Scanner;

public class TemperatureConversion {//зачет
    public static double getKelvinTemperature(double celsiusDegrees) {

        return celsiusDegrees + 273.15;
    }

    public static double getFahrenheitTemperature(double celsiusDegrees) {

        return (celsiusDegrees * 1.8) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите температуру по шкале Цельсия = ");
        double celsiusDegrees = scanner.nextDouble();

        System.out.println("Градусов по шкале Кельвина = " + getKelvinTemperature(celsiusDegrees));
        System.out.println("Градусов по шкале Фаренгейта = " + getFahrenheitTemperature(celsiusDegrees));
    }
}
