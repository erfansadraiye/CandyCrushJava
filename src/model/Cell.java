package model;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private Candy candy;

    public Cell(int xCoordinate, int yCoordinate, Candy candy) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.candy = candy;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    @Override
    public String toString() {
        return candy.toString();
    }
}
