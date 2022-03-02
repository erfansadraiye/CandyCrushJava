package view.menu;

import controller.GameController;
import controller.MainController;
import controller.RegisterController;
import model.User;
import view.ConsoleCommands;
import view.Menu;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class MainView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.START_GAME, input)) != null) {
            startGame(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.MENU_ENTER, input)) != null) {
            enterMenu(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_SCOREBOARD, input)) != null) {
            showScoreBoard();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.LOGOUT, input)) != null) {
            logout();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else {
            System.out.println("invalid command");
        }

    }

    public void help() {
        //TODO
        System.out.println("help");
    }

    private void showScoreBoard() {
        ArrayList<User> users = MainController.getInstance().getSortedScoreBoard();
        int index = 1;
        for (User user : users) {
            System.out.println(index + "- " + user.getUsername() + ": " + user.getHighScore());
            index++;
        }
    }

    private void enterMenu(Matcher matcher) {
        String menu = matcher.group("menu");
        try {
            MainController.getInstance().enterMenu(Menu.getMenu(menu));
            System.out.println("entered " + menu + " menu!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void startGame(Matcher matcher) {
        int seed = Integer.parseInt(matcher.group("seed"));
        int moves = Integer.parseInt(matcher.group("moves"));
        try {
            GameController.getInstance().startNewGame(seed, moves);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void logout() {
        RegisterController.getInstance().logout();
        System.out.println("User logged out!");
    }

}
