package model.combinations;

import model.Cell;
import model.Game;

public class ColourBombColourBombCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public ColourBombColourBombCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            return true;
        };
    }
}
