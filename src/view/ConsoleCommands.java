package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ConsoleCommands {
    //RegisterMenu:
    REGISTER("^register u (?<username>\\S+) p (?<password>\\S+) n (?<nickname>.+)$"),
    LOGIN("^login u (?<username>\\S+) p (?<password>\\S+)$"),

    //MainManu:
    MENU_ENTER("^enter (?<menu>\\w+) menu$"),
    START_GAME("^start new game (?<seed>\\d+) (?<moves>\\d+)"),
    LOGOUT("^logout$"),

    //Scoreboard:
    SHOW_SCOREBOARD("^show scoreboard$"),
    //GameMenu:
    SWIPE("^swipe (?<x>\\d+) (?<y>\\d+) (?<direction>[RLDU])$"),
    ACTIVE_LOLLIPOP_HAMMER("^active lollipop_hammer (?<x>\\d+) (?<y>\\d+)$"),
    ACTIVE_COLOUR_BOMB_BRUSH("^active colour_bomb_brush (?<x>\\d+) (?<y>\\d+)$"),
    ACTIVE_FREE_SWITCH("^active free_switch (?<x>\\d+) (?<y>\\d+) (?<direction>[vh])$"),
    ACTIVE_EXTRA_MOVES("^active extra_moves$"),
    ACTIVE_STRIPED_BRUSH("^active striped_brush (?<x>\\d+) (?<y>\\d+) (?<direction>[vh])$"),
    ACTIVE_WRAPPED_BRUSH("^active wrapped_brush (?<x>\\d+) (?<y>\\d+)$"),
    SHOW_BOARD("^show board$"),
    SHOW_BOOSTERS("^show boosters$"),

    //Profile menu:
    CHANGE_PASSWORD("^change password (?<oldpassword>\\S+) (?<newpassword>\\S+)$"),
    SHOW_INFO("^show information$"),
    //Shop menu
    SHOW_MONEY("^show money$"),
    SHOW_INVENTORY("^show inventory$"),
    BUY_BOOSTER("^buy (?<booster>\\w+) (?<count>\\d+)$"),

    BACK("^back$"),
    SHOW_CURRENT_MENU("^show current menu$"),
    EXIT("^exit$");

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
