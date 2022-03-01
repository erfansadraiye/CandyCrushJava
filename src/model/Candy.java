package model;

import model.combinations.CellCondition;

public class Candy {
    private final Color color;

    public Candy(Color color) {
        this.color = color;
    }
    public CellCondition getExplodeCondition(Coordinate coordinate) {
        return (Cell cell) -> {
            return cell.getCoordinate().equals(coordinate);
        };
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Candy(this.getColor());
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
