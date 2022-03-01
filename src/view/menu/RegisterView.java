package view.menu;

import controller.RegisterController;
import view.ConsoleCommands;

import java.util.regex.Matcher;

public class RegisterView extends ViewMenu {

    public void help() {
        System.out.println("help");//TODO fill
    }

    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.LOGIN, input)) != null) {
            loginUser(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.REGISTER, input)) != null) {
            createNewUser(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else {
            System.out.println("invalid command");
        }

    }

    private void createNewUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");
        try {
            RegisterController.getInstance().createUser(username, password, nickname);
            System.out.println("user created successfully!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void loginUser(Matcher matcher) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        try {
            RegisterController.getInstance().loginUser(username, password);
            System.out.println("user logged in successfully!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
