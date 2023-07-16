import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rest = 0;
        int acc = n;
        int count = 0;
        int summ = 0;
        while (acc != 0) {
            rest = acc % 10;
            acc = acc / 10;
            if (rest % 2 == 0)
                count++;
            else
                summ += rest;

        }System.out.println(summ);
        System.out.println(count);
    }
}