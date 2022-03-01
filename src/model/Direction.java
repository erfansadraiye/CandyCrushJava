package model;

public enum Direction {
    VERTICAL,
    HORIZONTAL;

    @Override
    public String toString() {
        switch (this) {
            case VERTICAL:
                return "V";
            case HORIZONTAL:
                return "H";
            default:
                return "X";
        }
    }
}
