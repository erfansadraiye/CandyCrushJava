package model.game;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValid(int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public int getMaxDistance(Coordinate other) {
        return Math.max(Math.abs(other.x - x), Math.abs(other.y - y));
    }

    public int getMinDistance(Coordinate other) {
        return Math.min(Math.abs(other.x - x), Math.abs(other.y - y));

    }

    public Coordinate getAdjacent(String direction) {
        switch (direction) {
            case "R":
                return new Coordinate(x, y + 1);
            case "D":
                return new Coordinate(x + 1, y);
            case "L":
                return new Coordinate(x, y - 1);
            case "U":
                return new Coordinate(x - 1, y);
            default:
                return this;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
