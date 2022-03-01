package model.combinations;

import model.game.Cell;
import model.game.Color;
import model.game.Coordinate;
import model.game.Game;

public class NormalCombination implements Combination {

    public NormalCombination() {
    }

    public CellCondition getCellCondition(Game game) {
        return (Cell cell) -> {
            int size = game.getBoard().getSize();
            int[][] zarib = new int[2][2];
            zarib[0][0] = 1;
            zarib[0][1] = 0;
            zarib[1][0] = 0;
            zarib[1][1] = 1;
            for (int w = 0; w < 2; w++) {
                for (int i = -2; i <= 0; i++) {
                    Coordinate firstCoordinate = new Coordinate(cell.getXCoordinate() + i * zarib[w][0], cell.getYCoordinate() + i * zarib[w][1]);
                    if (!firstCoordinate.isValid(size))
                        continue;
                    Color color = game.getCellByCoordinate(firstCoordinate).getCandy().getColor();
                    boolean isCorrect = true;
                    for (int j = 1; j < 3; j++) {
                        Coordinate coordinate = new Coordinate(firstCoordinate.getX() + j * zarib[w][0], firstCoordinate.getY() + j * zarib[w][1]);
                        if (!coordinate.isValid(size) || !game.getCellByCoordinate(coordinate).getCandy().getColor().equals(color))
                            isCorrect = false;
                    }
                    if (isCorrect) {

                        return true;
                    }
                }
            }
            return false;
        };
    }
}
