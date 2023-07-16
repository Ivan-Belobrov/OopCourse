package Student12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("new.txt"));

        int count = scanner.nextInt();
        double[] a = new double[count];

        for (int i = 0; i < a.length; ++i) {
            a[i] = scanner.nextDouble();
        }

        System.out.println(Arrays.toString(a));
        scanner.close();
    }
}