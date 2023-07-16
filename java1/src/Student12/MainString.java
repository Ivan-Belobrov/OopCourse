package Student12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class MainString {
    public static void main(String[] args) {
        try {
            // Загрузка изображения
            BufferedImage image = ImageIO.read(new File("image.jpg"));

            // Матрица коэффициентов для размытия
            float[] matrix = {
                    0.1f, 0.1f, 0.1f,
                    0.1f, 0.1f, 0.1f,
                    0.1f, 0.1f, 0.1f
            };

            // Создание объекта Kernel с заданной матрицей
            Kernel kernel = new Kernel(3, 3, matrix);

            // Создание объекта ConvolveOp с заданным kernel
            ConvolveOp convolveOp = new ConvolveOp(kernel);

            // Применение размытия к изображению
            BufferedImage blurredImage = convolveOp.filter(image, null);

            // Сохранение размытого изображения
            File output = new File("output.jpg");
            ImageIO.write(blurredImage, "jpg", output);

            System.out.println("Размытие успешно выполнено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
