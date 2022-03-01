package model.boosters;

public enum BoosterType {
    FREE_SWITCH(13),
    COLOUR_BOMB_BRUSH(20),
    STRIPED_BRUSH(15),
    LOLLIPOP_HAMMER(6),
    WRAPPED_BRUSH(15),
    EXTRA_MOVES(10);

    private int price;

    BoosterType(int price) {
        this.price = price;
    }

    public static BoosterType getBoosterByName(String name) {
        switch (name) {
            case "free_switch":
                return FREE_SWITCH;
            case "colour_bomb_brush":
                return COLOUR_BOMB_BRUSH;
            case "striped_brush":
                return STRIPED_BRUSH;
            case "lollipop_hammer":
                return LOLLIPOP_HAMMER;
            case "wrapped_brush":
                return WRAPPED_BRUSH;
            case "extra_moves":
                return EXTRA_MOVES;
            default:
                return null;
        }

    }

    public int getPrice() {
        return price;
    }
}
