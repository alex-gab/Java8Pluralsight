package com.alex.masteringlambdas;

import java.util.Arrays;
import java.util.List;

public final class LocalVariableCapture {
    public static void main(String[] args) {
        final List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        int sum = 0;

//        ints.forEach(e -> sum += e);
    }
}
