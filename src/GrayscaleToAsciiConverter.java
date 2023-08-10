public class GrayscaleToAsciiConverter implements AsciiConvertor {
    private final Image grayscaleImage;

    public GrayscaleToAsciiConverter(Image grayscaleImage) {
        this.grayscaleImage = grayscaleImage;
    }

    @Override
    public char[][] convert() {
        int width = grayscaleImage.getWidth();
        int height = grayscaleImage.getHeight();
        var asciiArt = new char[height][width];
        var pixels = grayscaleImage.getPixels();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                var gray = pixels[i][j].getRed();
                if (gray <= 85) {
                    asciiArt[i][j] = '#';
                } else if (gray <= 116) {
                    asciiArt[i][j] = '0';
                } else if (gray <= 144) {
                    asciiArt[i][j] = '|';
                } else if (gray <= 200) {
                    asciiArt[i][j] = ':';
                } else {
                    asciiArt[i][j] = '.';
                }
            }
        }

        return asciiArt;
    }
}
