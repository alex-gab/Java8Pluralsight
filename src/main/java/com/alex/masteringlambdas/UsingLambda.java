package com.alex.masteringlambdas;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public final class UsingLambda {
    public static void main(String[] args) {
//        final Object o = () -> "hi";
        Object s = (Supplier<String>) () -> "hi";
        Object c = (Callable<String>) () -> "hi";

//        c = (Callable<String>) s;
    }
}
