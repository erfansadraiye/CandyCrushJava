package model.combinations;

import model.candies.Candy;
import model.candies.ColourBomb;
import model.candies.StripedCandy;
import model.candies.WrappedCandy;
import model.game.Cell;

public class CombinationFinder {
    public static Combination Find(Cell first, Cell second) {
        Candy a = first.getCandy();
        Candy b = second.getCandy();
        if (a instanceof StripedCandy && b instanceof WrappedCandy)
            return new StripedWrappedCombination(first, second);
        if (a instanceof WrappedCandy && b instanceof StripedCandy)
            return new StripedWrappedCombination(first, second);

        if (a instanceof WrappedCandy && b instanceof WrappedCandy)
            return new WrappedWrappedCombination(first, second);

        if (a instanceof WrappedCandy && b instanceof ColourBomb)
            return new WrappedColourBombCombination(first, second);
        if (a instanceof ColourBomb && b instanceof WrappedCandy)
            return new WrappedColourBombCombination(first, second);

        if (a instanceof ColourBomb && b instanceof ColourBomb)
            return new ColourBombColourBombCombination(first, second);

        if (a instanceof StripedCandy && b instanceof ColourBomb)
            return new StripedColourBombCombination(first, second);
        if (a instanceof ColourBomb && b instanceof StripedCandy)
            return new StripedColourBombCombination(first, second);

        if (a instanceof StripedCandy && b instanceof StripedCandy)
            return new StripedStripedCombination(first, second);

        if (a instanceof ColourBomb || b instanceof ColourBomb)
            return new NormalColourBombCombination(first, second);

        return new NormalCombination();
    }
}
