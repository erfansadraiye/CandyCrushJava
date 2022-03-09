package view.menu;

import view.HandleRequestType;

public abstract class ViewMenu {
    abstract public void run(String input);
    public void showCurrentMenu() {
        System.out.println(HandleRequestType.currentMenu.toString());
    }
}
