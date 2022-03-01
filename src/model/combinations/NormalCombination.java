package model.combinations;

import model.Cell;
import model.Game;

public class NormalCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public NormalCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        // TODO. this is shit
        return (Cell cell) -> {
            return false;
        };
    }
}
