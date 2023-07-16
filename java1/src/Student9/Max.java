package Student9;

public class Max {
    public static void main(String[] args) {
        String str = "Аргентина манит негра";
        boolean isPalindrome = true;
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            char c1 = Character.toLowerCase(str.charAt(i));//compareToIgnoreCase
            char c2 = Character.toLowerCase(str.charAt(j));

            if (!Character.isLetter(c1)) {
                i++;
            } else if (!Character.isLetter(c2)) {
                j--;
            } else if (c1 != c2) {
                isPalindrome = false;
                break;
            } else {
                i++;
                j--;
            }
        }
        System.out.printf("Введенная фраза %s является палиндромом?' \"" + str + "\" a palindrome? " + isPalindrome);
    }
}