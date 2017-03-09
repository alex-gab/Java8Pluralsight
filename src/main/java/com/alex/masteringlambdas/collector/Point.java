package com.alex.masteringlambdas.collector;

public final class Point implements Comparable<Point> {
    private final int x;

    public Point(int x) {
        this.x = x;
    }

    public final int distance(final Point other) {
        return other.x - x;
    }

    @Override
    public String toString() {
        return String.format("(%d, 0)", x);
    }

    @Override
    public int compareTo(Point other) {
        return this.x < other.x ? -1 : (this.x > other.x ? 1 : 0);
    }
}
