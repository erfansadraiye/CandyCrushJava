package view.menu;

import controller.ScoreBoardController;
import model.User;
import view.ConsoleCommands;
import view.HandleRequestType;
import view.Menu;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class ScoreBoardView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_SCOREBOARD, input)) != null) {
            showScoreBoard();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BACK, input)) != null) {
            back();
        } else {
            System.out.println("invalid command");
        }
    }

    private void back() {
        HandleRequestType.currentMenu = Menu.MAIN_MENU;
    }

    private void showScoreBoard() {
        ArrayList<User> users = ScoreBoardController.getInstance().getSortedScoreBoard();
        int index = 1;
        for (User user : users) {
            System.out.println(index + "- " + user.getUsername() + ": " + user.getHighScore());
            index++;
        }
    }
    @Override
    public void help() {
        //Todo fill
        System.out.println("help");
    }
}
