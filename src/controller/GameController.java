package controller;

import model.*;
import model.combinations.CellCondition;
import model.combinations.Combination;
import model.combinations.CombinationFinder;
import model.combinations.NormalCombination;
import view.HandleRequestType;
import view.Menu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameController {
    private static GameController instance = null;
    private Game game;

    private GameController() {
    }

    public void startNewGame(int seed, int moves) {
        this.game = new Game(seed, moves);
        HandleRequestType.currentMenu = Menu.GAME_MENU;
    }


    public void swipeCell(Coordinate coordinate, String direction) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (!coordinate.getAdjacent(direction).isValid(game.getBoard().getSize()))
            throw new Exception("invalid destination");
        Cell first = game.getCellByCoordinate(coordinate);
        Cell second = game.getCellByCoordinate(coordinate.getAdjacent(direction));
        Combination combination = CombinationFinder.Find(first, second);
        Candy firstCandy = (Candy) first.getCandy().clone();
        Candy secondCandy = (Candy) second.getCandy().clone();
        game.getBoard().setCandy(first.getCoordinate(), secondCandy);
        game.getBoard().setCandy(second.getCoordinate(), firstCandy);
        if (!eatCandies(combination.getCellCondition(game))) {
            game.getBoard().setCandy(first.getCoordinate(), firstCandy);
            game.getBoard().setCandy(second.getCoordinate(), secondCandy);
            throw new Exception("invalid move");
        }
        game.decreaseCountMoves();
    }

    public boolean eatCandies(CellCondition condition) {
        int size = game.getBoard().getSize();
        boolean[][] mark = new boolean[size][size]; // TODO: check if it initializes as 0
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (condition.canExplodes(game.getCellByCoordinate(new Coordinate(i, j)))) {
                    queue.add(new Coordinate(i, j));
                    mark[i][j] = true;
                }
        if (queue.isEmpty())
            return false;
        while (!queue.isEmpty()) { // TODO: felan oon khoone avvali ha ham explode mishan
            Coordinate coordinate = queue.poll();
            CellCondition cellCondition = game.getCellByCoordinate(coordinate).getExplodeCondition();
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (!mark[i][j] && cellCondition.canExplodes(game.getCellByCoordinate(new Coordinate(i, j)))) {
                        queue.add(new Coordinate(i, j));
                        mark[i][j] = true;
                    }
        }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (mark[i][j])
                    game.getBoard().setCandy(new Coordinate(i, j), null);
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                if (!mark[i][j]) {
                    Coordinate coordinate = new Coordinate(i, j);
                    Cell cell = game.getCellByCoordinate(coordinate);
                    Candy candy = cell.getCandy();
                    cell.setCandy(null);
                    for (int k = size - 1; k >= i; k--) {
                        if (game.getCellByCoordinate(new Coordinate(k, j)).getCandy() == null) {
                            game.getCellByCoordinate(new Coordinate(k, j)).setCandy(candy);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                Coordinate coordinate = new Coordinate(i, j);
                if (game.getCellByCoordinate(coordinate).getCandy() == null) {
                    Color color = Color.getColorByNumber(game.getBoard().getFunction().nextInt());
                    game.getBoard().setCandy(coordinate, new Candy(color));
                }
            }
        }
        eatCandies(new NormalCombination().getCellCondition(game));
        return true;
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    @Override
    public String toString() {
        return game.toString();
    }
}
