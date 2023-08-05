import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String inputPath = "image.jpg";
        String outputPath = "outImage.jpg";

        try {
            BufferedImage inputImage = ImageIO.read(new File(inputPath));
            BufferedImage outputImage = blurImage(inputImage);

            ImageIO.write(outputImage, "jpg", new File(outputPath));
            System.out.println("Image blurred successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static BufferedImage blurImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage blurredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Matrix coefficients for blurring
        float[] blurMatrix = new float[]{
                0.111f, 0
        };
        return blurredImage;
    }
}