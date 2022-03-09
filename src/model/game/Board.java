package model.game;

import model.candies.Candy;

public class Board {
    private final int size = 11;
    private final Cell[][] table;
    private final Function function;

    public Board(Function function) {
        this.function = function;
        table = new Cell[size][size];
        for (int i = size - 1; i >= 0; i--)
            for (int j = size - 1; j >= 0; j--) {
                Color color = Color.getColorByNumber(this.function.nextInt());
                table[i][j] = new Cell(i, j, new Candy(color));
            }
    }

    public void setCell(Cell cell) {
        table[cell.getXCoordinate()][cell.getYCoordinate()] = cell;
    }

    public void setCandy(Coordinate coordinate, Candy candy) {
        table[coordinate.getX()][coordinate.getY()].setCandy(candy);
    }

    public Cell[][] getTable() {
        return table;
    }

    public Cell getCell(Coordinate coordinate) {
        return table[coordinate.getX()][coordinate.getY()];
    }

    public int getSize() {
        return size;
    }

    public Function getFunction() {
        return function;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                stringBuilder.append(table[i][j].toString()).append("\t");
            if (i != size - 1)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
