public class GrayscaleToAsciiConverter implements AsciiConvertor {
    private static final char SYMBOL_DARK = '#';
    private static final char SYMBOL_MEDIUM = '0';
    private static final char SYMBOL_LIGHT = '|';
    private static final char SYMBOL_LIGHTER = ':';
    private static final char SYMBOL_BLANK = '.';
    private final Image grayscaleImage;

    public GrayscaleToAsciiConverter(Image grayscaleImage) {
        this.grayscaleImage = grayscaleImage;
    }

    @Override
    public char[][] convert() {
        int width = grayscaleImage.getWidth();
        int height = grayscaleImage.getHeight();
        var pixels = grayscaleImage.getPixels();
        var asciiArt = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                var gray = pixels[i][j].getRed();
                asciiArt[i][j] = getAsciiSymbolForGray(gray);
            }
        }

        return asciiArt;
    }

    private char getAsciiSymbolForGray(int gray) {
        if (gray <= 85)
            return SYMBOL_DARK;
        if (gray <= 116)
            return SYMBOL_MEDIUM;
        if (gray <= 144)
            return SYMBOL_LIGHT;
        if (gray <= 200)
            return SYMBOL_LIGHTER;

        return SYMBOL_BLANK;
    }
}
