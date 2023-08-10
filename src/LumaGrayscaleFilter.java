public class LumaGrayscaleFilter extends GrayscaleFilter {
    public LumaGrayscaleFilter(Image image) {
        super(image);
    }

    @Override
    public void apply() {
        var pixels = getImage().getPixels();
        for (var row : pixels) {
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
