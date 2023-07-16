package Student11;

public class main {
    public static void main(String[] args) {
        int[] sortArray = {2, 3, 12, 6, 4, 1, 15, 10};

        for (int i = 0; i < sortArray.length; i++) {
            int pos = i;
            int min = sortArray[i];
            for (int j = i + 1; j < sortArray.length; j++) {
                if (sortArray[j] < min) {
                    pos = j;
                    min = sortArray[j];
                }
            }
            sortArray[pos] = sortArray[i];
            sortArray[i] = min;

        }
        for (int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + "\n");
        }
    }
}