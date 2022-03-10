package model.game;

public class Game {
    private int countMoves;
    private int score;
    private final Board board;

    public Game(int seed, int moves) {
        countMoves = moves;
        Function function = new Function(seed);
        this.board = new Board(function);
        score = 0;
    }

    public void increaseScore(int x) {
        score += x;
    }

    public void increaseCountMoves(int value) {
        countMoves += value;
    }

    public void decreaseCountMoves() {
        countMoves -= 1;
    }

    public Cell getCellByCoordinate(Coordinate coordinate) {
        return board.getCell(coordinate);
    }

    public Board getBoard() {
        return board;
    }

    public int getCountMoves() {
        return countMoves;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Moves: " + countMoves + "\n" +
                "Score: " + score + "\n" +
                board.toString();
    }
}
