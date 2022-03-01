package model.combinations;

import model.Cell;
import model.Game;

public class StripedWrappedCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public StripedWrappedCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            return cell.getCoordinate().getMinDistance(first.getCoordinate()) <= 3;
        };
    }
}
