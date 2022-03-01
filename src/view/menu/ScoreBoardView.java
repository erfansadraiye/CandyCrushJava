package view.menu;

import view.ConsoleCommands;

import java.util.regex.Matcher;

public class ScoreBoardView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else {
            System.out.println("invalid command");
        }
    }

    @Override
    public void help() {
        //Todo fill
        System.out.println("help");
    }
}
