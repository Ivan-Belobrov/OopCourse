package java1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageBlur {
    public static void main(String[] args) {
        try {
            BufferedImage inputImage = ImageIO.read(new File("image.jpg"));

            int matrixSize = 5;

            double[][] matrix = new double[matrixSize][matrixSize];
            double factor = 1.0 / (matrixSize * matrixSize);

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = factor;
                }
            }

            int width = inputImage.getWidth();
            int height = inputImage.getHeight();

            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            int xUpperLimit = width - 1;
            int yUpperLimit = height - 1;
            int[] newPixel = new int[3];

            Raster raster = inputImage.getRaster();
            WritableRaster writableRaster = outputImage.getRaster();

            for (int y = 1; y < yUpperLimit; y++) {
                for (int x = 1; x < xUpperLimit; x++) {
                    double sumR = 0;
                    double sumG = 0;
                    double sumB = 0;

                    for (int i = -1, neighborY = y - 1; i <= 1; neighborY++, i++) {
                        for (int j = -1, neighborX = x - 1; j <= 1; neighborX++, j++) {
                            int[] pixel = raster.getPixel(neighborX, neighborY, newPixel);
                            double matrixValue = matrix[i + 1][j + 1];

                            sumR += matrixValue * pixel[0];
                            sumG += matrixValue * pixel[1];
                            sumB += matrixValue * pixel[2];
                        }
                    }

                    int newRed = colorRange(sumR);
                    int newGreen = colorRange(sumG);
                    int newBlue = colorRange(sumB);

                    newPixel[0] = newRed;
                    newPixel[1] = newGreen;
                    newPixel[2] = newBlue;

                    writableRaster.setPixel(x, y, newPixel);
                }
            }

            ImageIO.write(outputImage, "jpg", new File("out.jpg"));

            System.out.println("Размытие выполнено.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении размытия: " + e.getMessage());
        }
    }

    private static int colorRange(double value) {
        return (int) Math.max(0, Math.min(255, Math.round(value)));
    }
}