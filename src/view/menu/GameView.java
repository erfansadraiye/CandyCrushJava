package view.menu;

import controller.GameController;
import model.Coordinate;
import model.Game;
import view.ConsoleCommands;

import java.util.regex.Matcher;

public class GameView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SWIPE, input)) != null) {
            swipe(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_BOARD, input)) != null) {
            showBoard();
        } else {
            System.out.println("invalid command");
        }
    }

    void swipe(Matcher matcher) {
        try {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            Coordinate coordinate = new Coordinate(x, y);
            char direction = (char) matcher.group("direction").indexOf(0);
            GameController.getInstance().swipeCell(coordinate, direction);
        } catch (Exception e) {

        }
    }

    void showBoard() {
        try {
            System.out.println(GameController.getInstance().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void help() {
        //TODO fill
        System.out.println("help");
    }
}
