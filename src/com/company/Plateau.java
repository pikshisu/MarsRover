package com.company;

public class Plateau {
    // Lower left coordinates are assumed to be (0,0)
    private final int x_min = 0, y_min = 0;
    private final int x_max, y_max;

    // Initialise upper right coordinates upon instantiation
    public Plateau(int x_limit, int y_limit) {
        if(x_limit < 1 || y_limit < 1) {
            throw new IllegalArgumentException("Invalid plateau size.");
        }
        this.x_max = x_limit;
        this.y_max = y_limit;
    }

    private boolean inRange(int num, int min, int max) {
        return (num >= min && num <= max);
    }

    public boolean isValidPositon(int x, int y) {
        return (inRange(x, x_min, x_max) && inRange(y, y_min, y_max));
    }
}
