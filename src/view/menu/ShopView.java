package view.menu;

import controller.RegisterController;
import controller.ShopController;
import model.User;
import model.boosters.BoosterType;
import view.ConsoleCommands;
import view.HandleRequestType;
import view.Menu;

import java.util.regex.Matcher;

public class ShopView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.HELP, input)) != null) {
            help();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BACK, input)) != null) {
            back();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_MONEY, input)) != null) {
            showMoney();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_INVENTORY, input)) != null) {
            showInventory();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_BOOSTER, input)) != null) {
            buyBooster(matcher);
        } else {
            System.out.println("invalid command");
        }
    }

    private void buyBooster(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        BoosterType boosterType = BoosterType.getBoosterByName(matcher.group("booster"));
        try {
            ShopController.getInstance().buyBooster(boosterType,count);
            System.out.println("Lollipop Hammer Sold.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void showInventory() {
        User onlineUser = RegisterController.getInstance().getOnlineUser();
        System.out.println("Lollipop Hammer : " + onlineUser.getCountLollipopHammer());
        System.out.println("Colour Bomb : " + onlineUser.getCountColourBomb());
        System.out.println("Extra Moves : " + onlineUser.getCountExtraMoves());
        System.out.println("Free Switch : " + onlineUser.getCountFreeSwitch());
        System.out.println("Striped Brush : " + onlineUser.getCountStripedBrush());
    }

    private void showMoney() {
        System.out.println("wallet : " + RegisterController.getInstance().getOnlineUser().getWallet());
    }


    @Override
    public void help() {
        //TODO fill
        System.out.println("help");
    }

    private void back() {
        HandleRequestType.currentMenu = Menu.MAIN_MENU;
    }

}
