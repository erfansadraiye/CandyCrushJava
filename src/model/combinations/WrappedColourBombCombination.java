package model.combinations;

import model.candies.ColourBomb;
import model.game.Cell;
import model.game.Color;
import model.game.Coordinate;
import model.game.Game;

public class WrappedColourBombCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public WrappedColourBombCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            Color wrappedColor;
            if (first.getCandy() instanceof ColourBomb)
                wrappedColor = second.getCandy().getColor();
            else
                wrappedColor = first.getCandy().getColor();;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    Coordinate coordinate = new Coordinate(cell.getXCoordinate() + i, cell.getYCoordinate() + j);
                    if (!coordinate.isValid(game.getBoard().getSize()))
                        continue;
                    Cell cell1 = game.getCellByCoordinate(coordinate);
                    if (cell1.getCandy().getColor().equals(wrappedColor))
                        return true;
                }
            }
            return false;
        };
    }
}
