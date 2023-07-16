package Student8;

public class Palindrome {
    public static boolean isPalindrome(String string) {
        if (string.isEmpty()) {
            return true;
        }

        string = string.toLowerCase();
        int startIndex = 0;
        int endIndex = string.length() - 1;

        while (startIndex < endIndex) {
            if (!Character.isLetter(string.charAt(startIndex))) {
                startIndex++;
                continue;
            }

            if (!Character.isLetter(string.charAt(endIndex))) {
                endIndex--;
                continue;
            }

            if (string.charAt(startIndex) != string.charAt(endIndex)) {
                return false;
            }

            startIndex++;
            endIndex--;

        }
        return true;
    }

    public static void main(String[] args) {
        String string = "";

        if (isPalindrome(string)) {
            System.out.println("Данная строка является палиндромом.");
        } else {
            System.out.println("Данная строка не является палиндромом.");
        }

        System.out.println(isPalindrome(string));
    }
}