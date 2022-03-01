package model.combinations;

import model.candies.Candy;
import model.candies.StripedCandy;
import model.game.Cell;
import model.game.Coordinate;
import model.game.Direction;
import model.game.Game;

public class StripedColourBombCombination implements Combination {
    private final Cell first;
    private final Cell second;

    public StripedColourBombCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            if (cell.getCoordinate().equals(first.getCoordinate()) ||
                    cell.getCoordinate().equals(second.getCoordinate()))
                return true;
            Direction direction;
            if (first.getCandy() instanceof StripedCandy)
                direction = ((StripedCandy) first.getCandy()).getDirection();
            else
                direction = ((StripedCandy) second.getCandy()).getDirection();
            for (int i = 0; i < game.getBoard().getSize(); i++) {
                Candy candy = null;
                if (direction.equals(Direction.VERTICAL))
                    candy = game.getCellByCoordinate(new Coordinate(i, cell.getYCoordinate())).getCandy();
                else
                    candy = game.getCellByCoordinate(new Coordinate(cell.getXCoordinate(), i)).getCandy();

                if (candy instanceof StripedCandy && candy.getColor().equals(cell.getCandy().getColor()))
                    return true;
            }
            return false;
        };
    }
}
