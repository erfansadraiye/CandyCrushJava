package controller;

public class GameController {
    private static GameController instance = null;
    private GameController(){

    }
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
}
