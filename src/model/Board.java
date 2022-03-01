package model;

import java.util.Arrays;

public class Board {
    private final int size = 10;
    private final Cell[][] table;

    public Board(Function function) {
        table = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                Color color = Color.getColorByNumber(function.nextInt());
                table[i][j] = new Cell(i, j, new Candy(color)); // TODO: color should change
            }
    }

    public void setCell(Cell cell) {
        table[cell.getXCoordinate()][cell.getYCoordinate()] = cell;
    }

    public Cell[][] getTable() {
        return table;
    }

    public int getSize() {
        return size;
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
