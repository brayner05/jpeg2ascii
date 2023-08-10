import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String imagePath = Console.readString("Image path: ");
        var imageReader = new ImageReader(imagePath);

        try {
            var image = imageReader.read();

            GrayscaleFilter filter = new LumaGrayscaleFilter(image);
            filter.apply();

            var asciiConverter = new GrayscaleToAsciiConverter(image);
            var asciiArt = asciiConverter.convert();

            for (var row : asciiArt) {
                for (var col : row) {
                    System.out.print(col + " ");
                }
                System.out.println('\b');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}