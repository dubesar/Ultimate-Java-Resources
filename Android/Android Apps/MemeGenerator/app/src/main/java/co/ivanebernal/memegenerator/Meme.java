package co.ivanebernal.memegenerator;

import android.graphics.Bitmap;

public class Meme {

    private Bitmap baseImage;

    private TextProperties topTextProperties;

    private TextProperties bottomTextProperties;

    public Meme(final Bitmap baseImage, final TextProperties topTextProperties,
            final TextProperties bottomTextProperties) {
        this.baseImage = baseImage;
        this.topTextProperties = topTextProperties;
        this.bottomTextProperties = bottomTextProperties;
    }

    public Meme(
            final Bitmap baseImage,
            final String topText, final Integer topSize, final Integer topColor,
            final String bottomText, final Integer bottomSize, final Integer bottomColor
    ) {
        this.baseImage = baseImage;
        this.topTextProperties = new TextProperties(topText, topSize, topColor);
        this.bottomTextProperties = new TextProperties(bottomText, bottomSize, bottomColor);
    }

    public void setBaseImage(final Bitmap baseImage) {
        this.baseImage = baseImage;
    }

    public Bitmap getBaseImage() {
        return baseImage;
    }

    public TextProperties getTopTextProperties() {
        return topTextProperties;
    }

    public void setTopTextProperties(final TextProperties topTextProperties) {
        this.topTextProperties = topTextProperties;
    }

    public TextProperties getBottomTextProperties() {
        return bottomTextProperties;
    }

    public void setBottomTextProperties(final TextProperties bottomTextProperties) {
        this.bottomTextProperties = bottomTextProperties;
    }
}
