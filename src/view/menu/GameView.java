package view.menu;

import controller.GameController;
import view.ConsoleCommands;

import java.util.regex.Matcher;

public class GameView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_BOARD, input)) != null) {
            showBoard();
        } else {
            System.out.println("invalid command");
        }
    }

    void showBoard() {
        try {
            System.out.println(GameController.getInstance().gameToString());
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
