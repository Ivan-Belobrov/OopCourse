package java1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBlur {
    public static void main(String[] args) {
        try {
            BufferedImage inputImage = ImageIO.read(new File("image.jpg"));

            double[] matrix = {
                    1.0 / 9, 1.0 / 9, 1.0 / 9,
                    1.0 / 9, 1.0 / 9, 1.0 / 9,
                    1.0 / 9, 1.0 / 9, 1.0 / 9
            };

            int width = inputImage.getWidth();
            int height = inputImage.getHeight();

            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    double sumR = 0;
                    double sumG = 0;
                    double sumB = 0;

                    for (int j = -1; j <= 1; j++) {
                        for (int i = -1; i <= 1; i++) {
                            int pixel = inputImage.getRGB(x + i, y + j);
                            int red = (pixel >> 16) & 0xFF;
                            int green = (pixel >> 8) & 0xFF;
                            int blue = pixel & 0xFF;

                            sumR += matrix[(j + 1) * 3 + (i + 1)] * red;
                            sumG += matrix[(j + 1) * 3 + (i + 1)] * green;
                            sumB += matrix[(j + 1) * 3 + (i + 1)] * blue;
                        }
                    }

                    int newRed = Math.min(255, Math.max(0, (int) sumR));
                    int newGreen = Math.min(255, Math.max(0, (int) sumG));
                    int newBlue = Math.min(255, Math.max(0, (int) sumB));

                    int newPixel = (newRed << 16) | (newGreen << 8) | newBlue;
                    outputImage.setRGB(x, y, newPixel);
                }
            }

            File outputFile = new File("out.jpg");
            ImageIO.write(outputImage, "jpg", outputFile);

            System.out.println("Размытие выполнено.");
        } catch (IOException e) {
            System.out.println("Ошибка при выполнении размытия: " + e.getMessage());
        }
    }
}