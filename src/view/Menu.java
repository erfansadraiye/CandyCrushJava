package view;

public enum Menu {
    EXIT,
    REGISTER_MENU,
    MAIN_MENU,
    PROFILE_VIEW,
    SHOP,
    GAME_MENU,
    SCOREBOARD;

    public static Menu getMenu(String menu) {
        switch (menu) {
            case "Login":
                return REGISTER_MENU;
            case "Main":
                return MAIN_MENU;
            case "Game":
                return GAME_MENU;
            case "Scoreboard":
                return SCOREBOARD;
            case "Profile":
                return PROFILE_VIEW;
            case "Shop":
                return SHOP;
            default:
                return null;
        }

    }
}
