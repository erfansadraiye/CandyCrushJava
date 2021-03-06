package model.candies;

import model.game.Color;

public class ColourBomb extends SpecialCandy {
    public ColourBomb() {
        super(Color.NoColor);
    }

    @Override
    public Object clone() {
        return new ColourBomb();
    }

    @Override
    public String toString() {
        return "CB";
    }
}