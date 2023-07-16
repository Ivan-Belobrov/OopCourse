package Student4;

public class Contribution {
    public static void main(String[] args) {
        int[] sum = {10, 90, -40, -12, 85, 80};//1 – 4 + 9 – 16 + 25 – 36
        int i = 0;
        double average;
        double c = 0;
        do {
            c += sum[i];
            ++i;
            average = c / i;
        } while (i < sum.length);
        System.out.println(average);
    }
}