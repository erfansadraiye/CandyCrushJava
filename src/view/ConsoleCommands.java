package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ConsoleCommands {
    //RegisterMenu:
    LOGIN("^user login (?:username|u) (?<username>\\w+) (?:password|p) (?<password>\\w+)$"),
    LOGOUT("user logout"),
    MENU_ENTER("menu enter (?<menu>\\w+)"),
    MENU_EXIT("menu exit"),
    CREATE_USER("^user create (?:username|u) (?<username>\\w+) (?:nickname|n) (?<nickname>\\w+) (?:password|p) (?<password>\\w+)$");

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
