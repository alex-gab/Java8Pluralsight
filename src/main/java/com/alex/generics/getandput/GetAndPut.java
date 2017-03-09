package com.alex.generics.getandput;

import java.util.function.Function;

public final class GetAndPut {
    public <T, R> void strange(Function<? extends T, ? extends R> f, T value) {
//        f.apply(value);
    }
}
