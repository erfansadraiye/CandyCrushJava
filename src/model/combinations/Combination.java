package model.combinations;

import model.Board;
import model.Cell;
import model.Game;

public interface Combination {
    public CellCondition getCellCondition(Game game);
}
