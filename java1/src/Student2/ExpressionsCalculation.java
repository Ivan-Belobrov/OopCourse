package Student2;

public class ExpressionsCalculation {
    public static void main(String[] args) {
        double x = 3 - ((56 - 12) / 44) * (4 / 2);
        double y = (2 * x) / (33 - x);
        double z = -x / (2 * y);

        System.out.println("Результат x = " + x);
        System.out.println("Результат y = " + y);
        System.out.println("Результат z = " + z);
    }
}
