package co.ivanebernal.memegenerator.model;

public class TextProperties {
    private String text;

    private Integer size;

    private Integer color;

    public TextProperties(final String text, final Integer size, final Integer color) {
        this.text = text;
        this.size = size;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(final Integer color) {
        this.color = color;
    }
}
