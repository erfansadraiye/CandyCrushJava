package view;


import view.menu.*;

import java.util.Scanner;

public class HandleRequestType {
    public static Scanner scanner = new Scanner(System.in);
    public static Menu currentMenu = Menu.REGISTER_MENU;
    ShopView shopView;
    GameView gameView;
    MainView mainView;
    ProfileView profileView;
    RegisterView registerView;
    String command = "";

    public void start() throws Exception {
        registerView = new RegisterView();
        profileView = new ProfileView();
        shopView = new ShopView();
        gameView = new GameView();
        mainView = new MainView();
        while (currentMenu != Menu.EXIT) {
            if (scanner.hasNext()) {
                command = scanner.nextLine();
            } else
                break;
            if (currentMenu == Menu.REGISTER_MENU) {
                if (command.equals("exit"))
                    break;
                registerView.run(command);
            } else if (currentMenu == Menu.MAIN_MENU) {
                mainView.run(command);
            } else if (currentMenu == Menu.PROFILE_VIEW) {
                profileView.run(command);
            } else if (currentMenu == Menu.GAME_MENU) {
                gameView.run(command);
            } else if (currentMenu == Menu.SHOP) {
                shopView.run(command);
            } else {
                throw new RuntimeException("core adaption failed!");
            }

        }
    }

}

