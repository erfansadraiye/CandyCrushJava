package model;

public class Candy {
    private final Color color;

    public Candy(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
