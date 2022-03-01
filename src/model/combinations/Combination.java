package model.combinations;

import model.game.Game;

public interface Combination {
    public CellCondition getCellCondition(Game game);
}
