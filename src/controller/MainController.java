package controller;

import view.HandleRequestType;
import view.Menu;

import java.util.regex.Matcher;

public class MainController {
    private static MainController instance;

    private MainController() {

    }

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();
        return instance;
    }


    public void enterMenu(Menu menu) throws Exception {
        if (menu == null)
            throw new Exception("invalid command");

        if (menu == Menu.MAIN_MENU || menu == Menu.REGISTER_MENU || menu == Menu.GAME_MENU)
            throw new Exception("menu navigation is not possible");

        HandleRequestType.currentMenu = menu;
    }

    public void startGame(Matcher matcher) {
        System.out.println("start");
        //TODO
    }


}
