package com.fischl.tools;

public class Range {
    int min;
    int max;
    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public boolean isInRange(int value) {
        return value >= min && value <= max;
    }
    public boolean isLeftBound(int value) {
        return value == min;
    }
    public boolean isRightBound(int value) {
        return value == max;
    }
    public boolean isOutRange(int value) {
        return value < min || value > max;
    }
}
