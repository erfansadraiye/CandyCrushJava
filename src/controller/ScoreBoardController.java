package controller;

import model.User;

import java.util.ArrayList;
import java.util.Comparator;

public class ScoreBoardController {
    private static ScoreBoardController instance;

    private ScoreBoardController() {

    }

    public static ScoreBoardController getInstance() {
        if (instance == null)
            instance = new ScoreBoardController();
        return instance;
    }
    public ArrayList<User> getSortedScoreBoard() {
        ArrayList<User> players = RegisterController.getInstance().getAllUsers();
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
