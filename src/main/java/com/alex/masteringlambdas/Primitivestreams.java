package com.alex.masteringlambdas;

import java.util.Arrays;
import java.util.Optional;

public final class Primitivestreams {
    public static void main(String[] args) {
        final Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5).stream().
                map(i -> i + 1).
                max(Integer::compareTo);

        Arrays.asList(1, 2, 3, 4, 5).stream().mapToInt(Integer::intValue);
    }
}
