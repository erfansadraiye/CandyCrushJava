package model.game;

import model.candies.Candy;
import model.combinations.CellCondition;

public class Cell {
    private Coordinate coordinate;
    private Candy candy;

    public Cell(int xCoordinate, int yCoordinate, Candy candy) {
        coordinate = new Coordinate(xCoordinate, yCoordinate);
        this.candy = candy;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getXCoordinate() {
        return coordinate.getX();
    }

    public int getYCoordinate() {
        return coordinate.getY();
    }

    public Candy getCandy() {
        return candy;
    }

    public CellCondition getExplodeCondition() {
        return (Cell cell) -> this.candy.getExplodeCondition(getCoordinate()).canExplodes(cell);
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    @Override
    public String toString() {
        return candy.toString();
    }
}
