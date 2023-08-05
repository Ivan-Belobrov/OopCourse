import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int matrixSize = 5;

        double[][] matrix = new double[matrixSize][matrixSize];
        double factor = 1.0 / (matrixSize * matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = factor;
                System.out.println(Arrays.toString(matrix));
            }
        }
    }
}
