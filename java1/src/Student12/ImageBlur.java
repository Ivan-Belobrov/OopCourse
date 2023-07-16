package Student12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class ImageBlur {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("image.jpg"));

            float[] matrix = {
                    -0.1f, -0.1f, -0.1f,
                    -0.1f, -0.1f, -0.1f,
                    -0.1f, -0.1f, -0.1f
            };

            Kernel kernel = new Kernel(3, 3, matrix);

            ConvolveOp convolveOp = new ConvolveOp(kernel);

            BufferedImage blurredImage = convolveOp.filter(image, null);

            File output = new File("output.jpg");
            ImageIO.write(blurredImage, "jpg", output);

            System.out.println("Размытие выполнено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}