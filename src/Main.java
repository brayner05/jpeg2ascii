import java.io.File;

public class Main {
    public static void main(String[] args) {
        String imagePath = args.length > 0 ? args[0] : Console.readString("Image path: ");
        var imageReader = new ImageReader(new File(imagePath));

        try {
            var image = imageReader.read();

            GrayscaleFilter filter = new LumaGrayscaleFilter(image);
            filter.apply();

            AsciiConvertor asciiConverter = new GrayscaleToAsciiConverter(image);
            var asciiArt = asciiConverter.convert();

            for (var row : asciiArt) {
                for (var col : row) {
                    System.out.print(col + " ");
                }
                System.out.println('\b');
            }

        } catch (Exception e) {
            System.out.println("Encountered an error: " + e.getMessage());
        }
    }
}