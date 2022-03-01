package model;

public class SpecialCandy extends Candy {
    public SpecialCandy(Color color) {
        super(color);
    }

    @Override
    public Object clone() {
        return new SpecialCandy(this.getColor());
    }
}
