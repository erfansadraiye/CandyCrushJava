package model.combinations;

import model.candies.Candy;
import model.candies.StripedCandy;
import model.game.Cell;
import model.game.Coordinate;
import model.game.Direction;
import model.game.Game;

public class StripedStripedCombination implements Combination {
    private final Cell first;
    private final Cell second;

    public StripedStripedCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            return Math.min(cell.getCoordinate().getMinDistance(first.getCoordinate()),
                            cell.getCoordinate().getMinDistance(second.getCoordinate())) == 0;
        };
    }
}
