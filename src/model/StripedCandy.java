package model;

public class StripedCandy extends SpecialCandy {

    private final Direction direction;

    public StripedCandy(Color color, Direction direction) {
        super(color);
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return super.toString() + direction.toString();
    }
}
