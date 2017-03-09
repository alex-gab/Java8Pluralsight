package com.alex.masteringlambdas;

import java.util.List;

public final class FieldCapture {
    int sum;

    public final void makeSum(List<Integer> ints) {
        ints.forEach(e -> sum += e);
    }
}
