package model.combinations;

import model.game.Cell;

public interface CellCondition {
    public boolean canExplodes(Cell cell);
}
