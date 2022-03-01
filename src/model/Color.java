package model;

public enum Color {
    RED,
    Orange,
    Yellow,
    Green,
    Blue,
    Purple,
    NoColor;

    public static Color getColorByNumber(int number) {
        switch (number) {
            case 0:
                return Color.RED;
            case 1:
                return Color.Orange;
            case 2:
                return Color.Yellow;
            case 3:
                return Color.Green;
            case 4:
                return Color.Blue;
            case 5:
                return Color.Purple;
            default:
                return Color.NoColor;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case RED:
                return "R";
            case Orange:
                return "O";
            case Yellow:
                return "Y";
            case Green:
                return "G";
            case Blue:
                return "B";
            case Purple:
                return "P";
            default:
                return "X";
        }
    }
}
