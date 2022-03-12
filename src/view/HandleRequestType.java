package view;


import view.menu.*;

import java.io.File;
import java.io.FileWriter;
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
//        FileWriter file = new FileWriter("input9.txt");
        while (currentMenu != Menu.EXIT) {
            if (scanner.hasNext()) {
                command = scanner.nextLine();
            } else
                break;
//            file.write(command+"\n");
            if (command.equals("exit"))
                break;
            if (currentMenu == Menu.REGISTER_MENU) {
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
//        file.close();
    }

}

