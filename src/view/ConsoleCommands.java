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
    SHOW_SCOREBOARD("^show scoreboard$"),
    //GameMenu:
    SWIPE("^swipe (?<x>\\d+) (?<y>\\d+) (?<direction>[RLDU])$"),
    ACTIVE_LOLLIPOP_HAMMER("^active lollipop hammer (?<x>\\d+) (?<y>\\d+)$"),
    ACTIVE_COLOUR_BOMB("^active colour bomb (?<x>\\d+) (?<y>\\d+)$"),
    ACTIVE_FREE_SWITCH("^free switch (?<x>\\d+) (?<y>\\d+) (?<direction>[vh])$"),
    ACTIVE_EXTRA_MOVES("^active extra moves$"),
    ACTIVE_STRIPED_BRUSH("^active colour bomb (?<x>\\d+) (?<y>\\d+)$"),
    SHOW_BOARD("^show board$"),
    SHOW_BOOSTERS("^show boosters$"),

    //Profile menu:
    CHANGE_PASSWORD("^change password (?<old_password>\\w+) (?<new_password>\\w+)$"),
    SHOW_INFO("^show information$"),
    //Shop menu
    SHOW_MONEY("^show money$"),
    SHOW_INVENTORY("^show inventory$"),
    BUY_LOLLIPOP_HAMMER("^buy lollipop hammer (?<count>\\d+)$"),
    BUY_EXTRA_MOVES("^buy extra moves (?<count>\\d+)$"),
    BUY_COLOUR_BOMB("^buy colour bomb (?<count>\\d+)$"),
    BUY_FREE_SWITCH("^buy free switch (?<count>\\d+)$"),
    BUY_STRIPED_BRUSH("^buy striped brush (?<count>\\d+)$"),
    BACK("^back$"),
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
