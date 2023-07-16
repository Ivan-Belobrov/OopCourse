package Student6;

public class Main {

    public static double get_X_plus_Y(double x, double y) {
        return 3 * x + 4 * y;
    }

    public static int getAverage(int begin, int end) {
        int sum = 0;
        int count = 0;
        for (int i = begin; i <= end; i++) {
            sum += i;
            ++count;
        }
        return sum / count;
    }

    public static int getMax(int number1, int number2) {
        int max;
        if (number1 > number2) {
            max = number1;
            return max;
        }
        return number2;
    }

    public static int getMin(int number1, int number2) {
        int min;
        if (number1 > number2) {
            min = number2;
            return min;
        }
        return number1;
    }

    public static void main(String[] args) {
        System.out.println("Результ = " + get_X_plus_Y(9, 10));
        System.out.println("Результ = " + get_X_plus_Y(5, 6));
        System.out.println("Результ = " + getAverage(2, 25));
        System.out.println("Результ = " + getAverage(6, 536));
        System.out.println("Max число = " + getMax(60, 15));
        System.out.println("Max число = " + getMax(60, 54));
        System.out.println("Min число = " + getMin(12, 5));
        System.out.println("Min число = " + getMin(10, 9));
    }
}