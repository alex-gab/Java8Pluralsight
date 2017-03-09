package com.alex.masteringlambdas;

import java.util.Comparator;

public final class OverloadResolution {
    public static void main(String[] args) {
        Comparator<String> cs = Comparators.comparing((String s) -> s.length());
    }
}
