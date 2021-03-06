package view.menu;

import controller.RegisterController;
import model.User;
import view.ConsoleCommands;
import view.HandleRequestType;
import view.Menu;

import java.util.regex.Matcher;

public class ProfileView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BACK, input)) != null) {
            back();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.CHANGE_PASSWORD, input)) != null) {
            changePassword(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.REMOVE_USER, input)) != null) {
            removeAccount(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_INFO, input)) != null) {
            showInfo();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BACK, input)) != null) {
            back();
        } else {
            System.out.println("invalid command");
        }
    }

    private void removeAccount(Matcher matcher) {
        String password = matcher.group("password");
        try {
            RegisterController.getInstance().deleteAccount(password);
            System.out.println("account deleted!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showInfo() {
        User onlineUser = RegisterController.getInstance().getOnlineUser();
        System.out.println("username : " + onlineUser.getUsername());
        System.out.println("nickname : " + onlineUser.getNickname());
        System.out.println("money : " + onlineUser.getWallet());
        System.out.println("highscore : " + onlineUser.getHighScore());
    }

    private void changePassword(Matcher matcher) {
        String oldPassword = matcher.group("oldpassword");
        String newPassword = matcher.group("newpassword");
        try {
            RegisterController.getInstance().changePassword(oldPassword,newPassword);
            System.out.println("password changed!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void back() {
        HandleRequestType.currentMenu = Menu.MAIN_MENU;
    }

}
