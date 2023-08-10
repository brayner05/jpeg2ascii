import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {
    private final File file;

    public ImageWriter(File file) {
        this.file = file;
    }

    public void write(Image image) throws IOException {
        var pixels = image.getPixels();
        var width = image.getWidth();
        var height = image.getHeight();

        var buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grayValue = pixels[i][j].getRed();
                int rgb = (grayValue << 16) | (grayValue << 8) | grayValue;
                buffer.setRGB(j, i, rgb);
            }
        }

        ImageIO.write(buffer, "jpg", file);
    }
}
