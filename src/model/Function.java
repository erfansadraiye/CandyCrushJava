package model;

import java.util.Random;

public class Function {
    private final Random randomobj;

    private int x = 0, y = 0;
    private int cnt = 0;

    public Function(int seed) {
        randomobj = new Random();
        randomobj.setSeed(seed);
    }

    public int nextInt() {
        cnt++;
        if (cnt % 2 == 0)
            return randomobj.nextInt(3) - 1;
        else
            return randomobj.nextInt(3) + 2;
    }

}
