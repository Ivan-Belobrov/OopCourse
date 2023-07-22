package java1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class BlackAndWhiteColors {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("image.jpg"));
        WritableRaster raster = image.getRaster();

        int width = raster.getWidth();
        int height = raster.getHeight();

        final int COLORS_COUNT_IN_RGB = 3;

        int[] pixel = new int[COLORS_COUNT_IN_RGB];

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                raster.getPixel(x, y, pixel);

                int grayColor = (int) Math.round(0.3 * pixel[0] + 0.59 * pixel[1] + 0.11 * pixel[2]);
                pixel[0] = grayColor;
                pixel[1] = grayColor;
                pixel[2] = grayColor;

                raster.setPixel(x, y, pixel);
            }
        }

        ImageIO.write(image, "jpg", new File("out.jpg"));
    }
}