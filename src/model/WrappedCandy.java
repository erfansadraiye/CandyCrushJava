package model;

public class WrappedCandy extends SpecialCandy {
    public WrappedCandy(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return super.toString() + "W";
    }
}