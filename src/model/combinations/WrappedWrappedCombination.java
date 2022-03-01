package model.combinations;

import model.game.Cell;
import model.game.Game;

public class WrappedWrappedCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public WrappedWrappedCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            return Math.min(cell.getCoordinate().getMaxDistance(first.getCoordinate()),
                            cell.getCoordinate().getMaxDistance(second.getCoordinate())) < 3;
        };
    }
}
