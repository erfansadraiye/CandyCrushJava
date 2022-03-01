package view.menu;

import controller.RegisterController;
import controller.ShopController;
import model.User;
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
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_LOLLIPOP_HAMMER, input)) != null) {
            buyLollipopHammer(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_COLOUR_BOMB, input)) != null) {
            buyColourBomb(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_EXTRA_MOVES, input)) != null) {
            buyExtraMoves(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_FREE_SWITCH, input)) != null) {
            buyFreeSwitch(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.BUY_STRIPED_BRUSH, input)) != null) {
            buyStripedBrush(matcher);
        } else {
            System.out.println("invalid command");
        }
    }

    private void buyLollipopHammer(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        try {
            ShopController.getInstance().buyLollipopHammer(count);
            System.out.println("Lollipop Hammer Sold.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void buyColourBomb(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        try {
            ShopController.getInstance().buyColourBomb(count);
            System.out.println("Colour Bomb Sold.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void buyExtraMoves(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        try {
            ShopController.getInstance().buyExtraMoves(count);
            System.out.println("Extra Moves Sold.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void buyFreeSwitch(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        try {
            ShopController.getInstance().buyFreeSwitch(count);
            System.out.println("Free Switch Sold.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void buyStripedBrush(Matcher matcher) {
        int count = Integer.parseInt(matcher.group("count"));
        try {
            ShopController.getInstance().buyStripedBrush(count);
            System.out.println("Striped Brush Sold.");
        }catch (Exception e){
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
