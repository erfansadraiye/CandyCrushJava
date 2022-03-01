package model.boosters;

public enum BoosterType {
    FREE_SWITCH("free_switch", 13),
    COLOUR_BOMB_BRUSH("colour_bomb_brush", 20),
    STRIPED_BRUSH("striped_brush", 15),
    LOLLIPOP_HAMMER("lollipop_hammer", 6),
    WRAPPED_BRUSH("wrapped_brush", 15),
    EXTRA_MOVES("extra_moves", 10);

    private int price;
    private String name;

    BoosterType(String name, int price) {
        this.name = name;
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

    public String getName(){
        return name;
    }
}
