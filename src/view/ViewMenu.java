package view;

public abstract class ViewMenu {
    abstract public void help();
    abstract public void run(String input);
    public void showCurrentMenu() {
        System.out.println(HandleRequestType.currentMenu.toString());
    }
}
