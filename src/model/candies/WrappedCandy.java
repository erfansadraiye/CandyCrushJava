package model.candies;

import model.game.Cell;
import model.game.Color;
import model.game.Coordinate;
import model.combinations.CellCondition;

public class WrappedCandy extends SpecialCandy {
    public WrappedCandy(Color color) {
        super(color);
    }

    @Override
    public CellCondition getExplodeCondition(Coordinate coordinate) {
        return (Cell cell) -> cell.getCoordinate().getMaxDistance(coordinate) <= 1;
    }

    @Override
    public Object clone() {
        return new WrappedCandy(this.getColor());
    }

    @Override
    public String toString() {
        return super.toString() + "W";
    }
}