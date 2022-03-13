package controller;

import model.User;
import view.HandleRequestType;
import view.Menu;

import java.util.ArrayList;
import java.util.Comparator;
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
        HandleRequestType.currentMenu = menu;
    }
    public ArrayList<User> getSortedScoreBoard() {
        ArrayList<User> players = (ArrayList<User>) RegisterController.getInstance().getAllUsers().clone();
        players.sort(new SortByScore());
        return players;
    }


}

class SortByScore implements Comparator<User> {
    public int compare(User user1, User user2) {
        if (user1.getHighScore() != user2.getHighScore())
            return (int) (user2.getHighScore() - user1.getHighScore());
        else
            return user1.getUsername().compareTo(user2.getUsername());
    }
}
