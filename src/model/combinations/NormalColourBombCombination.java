package model.combinations;

import model.candies.ColourBomb;
import model.game.Cell;
import model.game.Color;
import model.game.Coordinate;
import model.game.Game;

public class NormalColourBombCombination implements Combination {
    private final Cell first;
    private final Cell second;
    public NormalColourBombCombination(Cell a, Cell b) {
        first = a;
        second = b;
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            if (cell.getCoordinate().equals(first.getCoordinate()) ||
                    cell.getCoordinate().equals(second.getCoordinate()))
                return true;
            Color color;
            if (first.getCandy() instanceof ColourBomb)
                color = second.getCandy().getColor();
            else
                color = first.getCandy().getColor();
            return cell.getCandy().getColor().equals(color);
        };
    }
}
