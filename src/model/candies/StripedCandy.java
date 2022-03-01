package model.candies;

import model.game.Cell;
import model.game.Color;
import model.game.Coordinate;
import model.game.Direction;
import model.combinations.CellCondition;

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
    public CellCondition getExplodeCondition(Coordinate coordinate) {
        return (Cell cell) -> {
            if (direction.equals(Direction.VERTICAL))
                return cell.getYCoordinate() == coordinate.getY();
            else
                return cell.getXCoordinate() == coordinate.getX();
        };
    }

    @Override
    public Object clone() {
        return new StripedCandy(this.getColor(), this.getDirection());
    }

    @Override
    public String toString() {
        return super.toString() + direction.toString();
    }
}
