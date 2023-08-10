public class Image {
    private final Pixel[][] pixels;
    private final int width;
    private final int height;

    public Image(Pixel[][] pixels) {
        this.pixels = pixels;
        this.width = pixels[0].length;
        this.height = pixels.length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pixel[][] getPixels() {
        return pixels;
    }
}
