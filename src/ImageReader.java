import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private final String path;

    public ImageReader(String path) {
        this.path = path;
    }

    public Image read() throws IOException {
        var imageFile = new File(path);
        var image = ImageIO.read(imageFile);
        var width = image.getWidth();
        var height = image.getHeight();
        var pixels = new Pixel[image.getHeight()][image.getWidth()];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                pixels[i][j] = new Pixel(red, green, blue);
            }
        }

        return new Image(pixels);
    }
}
