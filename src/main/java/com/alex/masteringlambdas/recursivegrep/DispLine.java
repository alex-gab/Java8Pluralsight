package com.alex.masteringlambdas.recursivegrep;

public final class DispLine {
    final int disp;
    final String line;

    public DispLine(int disp, String line) {
        this.disp = disp;
        this.line = line;
    }

    @Override
    public String toString() {
        return disp + ": " + line;
    }
}
