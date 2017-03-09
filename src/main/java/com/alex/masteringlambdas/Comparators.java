package com.alex.masteringlambdas;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public final class Comparators {
    public static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        return null;
    }

    public static <T> Comparator<T> comparing(ToIntFunction<T> keyExtractor) {
        return null;
    }
}
