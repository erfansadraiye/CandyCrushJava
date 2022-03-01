package model.combinations;

import model.*;

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
        return new NormalCombination(first, second);
    }
}
