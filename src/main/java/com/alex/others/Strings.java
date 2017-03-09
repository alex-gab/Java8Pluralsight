package com.alex.others;

import java.util.StringJoiner;

public final class Strings {
    public static void main(String[] args) {
        final StringJoiner joiner = new StringJoiner(", ", "{", "}").add("a").add("b").add("c").add("d");
        System.out.println(joiner.toString());

        System.out.println(String.join(", ", "a", "b", "c", "d"));
    }
}
