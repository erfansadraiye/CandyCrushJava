package controller;

import model.Game;
import view.HandleRequestType;
import view.Menu;

public class GameController {
    private static GameController instance = null;
    private Game game;
    private GameController(){
    }

    public void startNewGame(int a, int b, int c, int moves) {
        this.game = new Game(a, b, c, moves); // TODO;
        HandleRequestType.currentMenu = Menu.GAME_MENU;
    }

    public String gameToString() {
        return game.toString();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
}
