package Student5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 100; i >= 1; i--) {
            if (i % 4 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (int n = 4; n >= 0; --n) {
            System.out.print(Math.pow(n, 2) + " ");
        }
        System.out.println();

        int sum = 0;
        int count = 0;
        int sum2 = 0;

        for (int i = 0; i < 10; ++i) {
            sum += i;
            ++count;
            sum2 = sum / count;
            System.out.print(sum2 + " ");
        }
    }
}