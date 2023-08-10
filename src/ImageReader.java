import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private final File file;

    public ImageReader(File file) {
        this.file = file;
    }

    public Image read() throws IOException {
        var image = ImageIO.read(file);
        var width = image.getWidth();
        var height = image.getHeight();
        var pixels = new Pixel[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }

        return new Image(pixels);
    }
}
