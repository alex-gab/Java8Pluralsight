package com.alex.generics;

import java.util.Arrays;
import java.util.List;

public final class WildcardsWithSuper {
    public static void main(String[] args) {
        List<Object> objs = Arrays.asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        copy(objs, ints);
        assert objs.toString().equals("[5, 6, four]");
    }

    static <T> void copy(List<? super T> dst, List<? extends T> src) {
        final Object object = dst.get(1);
        src.remove(1);
    }
}
