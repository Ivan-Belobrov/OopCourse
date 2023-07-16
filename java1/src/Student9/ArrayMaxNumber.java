package Student9;

public class ArrayMaxNumber {
    public static double getMaxArray(double[] array) {
        double maxNumber = array[0];

        for (double e : array) {
            if (e > maxNumber) {
                maxNumber = e;
            }
        }

        return maxNumber;
    }

    public static void main(String[] args) {
        double[] array = {0.52, 17.00, 22};
        double maxNumber = getMaxArray(array);
        System.out.println("Максимальное число: " + maxNumber);
    }
}