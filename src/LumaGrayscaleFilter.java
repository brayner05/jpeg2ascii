public class LumaGrayscaleFilter implements GrayscaleFilter {
    private final Image image;

    public LumaGrayscaleFilter(Image image) {
        this.image = image;
    }

    @Override
    public void apply() {
        for (var row : image.getPixels()) {
            for (var pixel : row) {
                int red = pixel.getRed();
                int blue = pixel.getBlue();
                int green = pixel.getGreen();
                int gray = (int) (red * 0.2627 + green * 0.6780 + blue * 0.0593);
                pixel.setColour(gray, gray, gray);
            }
        }
    }
}
