package Student8;

import java.util.Scanner;

public class MaxSubstring {
    public static int getMaxSubstringLength(String string) {
        if (string.isEmpty()) {
            return 0;
        }

        int substringLength = 1;
        int maxSubstringLength = 1;

        for (int i = 1; i < string.length(); ++i) {
            if (Character.toLowerCase(string.charAt(i)) == Character.toLowerCase(string.charAt(i - 1))) {
                substringLength++;
                maxSubstringLength = Math.max(maxSubstringLength, substringLength);
            } else {
                substringLength = 1;
            }
        }

        return maxSubstringLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¬ведите любые символы:");
        String string = scanner.nextLine();

        System.out.println("ƒлина максимальной подстроки = " + getMaxSubstringLength(string));
    }
}