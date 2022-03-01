package view.menu;

import view.ConsoleCommands;
import view.HandleRequestType;
import view.Menu;

import java.util.regex.Matcher;

public class ProfileView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
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

    @Override
    public void help() {
        //TODO fill
        System.out.println("help");
    }
}
