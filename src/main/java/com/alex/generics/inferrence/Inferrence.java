package com.alex.generics.inferrence;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class Inferrence {
    public static void main(String[] args) {
        call(Arrays.<Object>asList(1, "two"));
//        final List<Object> list = Arrays.asList(1, "two");
    }

    private static void call(List<Serializable> serializables) {

    }

    private static void call(Collection<Object> serializables) {

    }

}
