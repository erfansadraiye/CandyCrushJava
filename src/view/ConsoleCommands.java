package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ConsoleCommands {
    //RegisterMenu:
    REGISTER("^register (?<username>\\w+) (?<password>\\S+) (?<nickname>\\w+)$"),
    LOGIN("^login (?<username>\\w+) (?<password>\\S+)$"),

    //MainManu:
    MENU_ENTER("^enter (?<menu>\\w+) menu$"),
    START_GAME("^start new game (?<a>\\d+) (?<b>\\d+) (?<c>\\d+) (?<moves>\\d+)"),
    LOGOUT("^logout$"),

    //Scoreboard:
    SHOW_SCOREBOARD("show scoreboard"),

    //Profile menu:
    CHANGE_PASSWORD("change password (?<old_password>\\w+) (?<new_password>\\w+)"),
    SHOW_INFO("show information"),
    BACK("back"),
    SHOW_CURRENT_MENU("^show current menu$"),
    MENU_EXIT("^menu exit$"),
    HELP("^help$");
    public String label;

    ConsoleCommands(String string) {
        this.label = string;
    }

    public static Matcher getMatcher(ConsoleCommands consoleCommands, String command) {
        Pattern pattern = Pattern.compile(consoleCommands.getValue());
        Matcher matcher = pattern.matcher(command);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }

    private String getValue() {
        return label;
    }
}
