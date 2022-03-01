package model;

public class Function {
    private final int a;
    private final int b;
    private final int c;

    private int x = 0, y = 0;

    public Function(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int nextInt() {
        int z = (a * x * x + b * y + c) % 6;
        x = y;
        y = z;
        return z;
    }

}
