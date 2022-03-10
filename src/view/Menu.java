package view;

public enum Menu {
    EXIT,
    REGISTER_MENU,
    MAIN_MENU,
    PROFILE_VIEW,
    SHOP,
    GAME_MENU;
    public static Menu getMenu(String menu) {
        switch (menu) {
            case "Profile":
                return PROFILE_VIEW;
            case "Shop":
                return SHOP;
            default:
                return null;
        }

    }

    @Override
    public String toString() {
        switch (HandleRequestType.currentMenu) {
            case REGISTER_MENU:
                return "Register Menu";
            case MAIN_MENU:
                return "Main Menu";
            case GAME_MENU:
                return "Game Menu";
            case PROFILE_VIEW:
                return "Profile Menu";
            case SHOP:
                return "Shop Menu";
            default:
                return null;
        }
    }
}
