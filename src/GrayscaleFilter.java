public abstract class GrayscaleFilter {
    private Image image;

    public GrayscaleFilter(Image image) {
        this.image = image;
    }

    public abstract void apply();

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
