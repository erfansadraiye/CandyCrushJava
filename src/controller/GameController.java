package controller;

import model.Cell;
import model.Coordinate;
import model.Game;
import model.combinations.Combination;
import model.combinations.CombinationFinder;
import view.HandleRequestType;
import view.Menu;

public class GameController {
    private static GameController instance = null;
    private Game game;
    private GameController(){
    }

    public void startNewGame(int a, int b, int c, int moves) {
        this.game = new Game(a, b, c, moves);
        HandleRequestType.currentMenu = Menu.GAME_MENU;
    }


    public void swipeCell(Coordinate coordinate, char direction) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (!coordinate.getAdjacent(direction).isValid(game.getBoard().getSize()))
            throw new Exception("invalid destination");
        Cell first = game.getCellByCoordinate(coordinate);
        Cell second = game.getCellByCoordinate(coordinate.getAdjacent(direction));
        Combination combination = CombinationFinder.Find(first, second);
        for (int i = 0; i < game.getBoard().getSize(); i++)
            for (int j = 0; j < game.getBoard().getSize(); j++)
                if (combination.getCellCondition(game).canSelect(game.getCellByCoordinate(new Coordinate(i, j))))
                    System.out.println("This will destroy : " + i + " , " + j);
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
