
public class Cat {
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 3, 5, 4, 6, 7};

        for (int j : array) {
            System.out.print(" " + j);
        }

        System.out.println();

        int lengthArray = array.length;
        int currentSymbol;

        for (int i = 0; i < lengthArray / 2; i++) {
            currentSymbol = array[lengthArray - i - 1];
            array[lengthArray - i - 1] = array[i];
            array[i] = currentSymbol;
        }

        for (int j : array) {
            System.out.print(" " + j);
        }
    }
}