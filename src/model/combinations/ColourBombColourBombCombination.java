package model.combinations;

import model.game.Cell;
import model.game.Game;

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
