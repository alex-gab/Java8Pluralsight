package com.alex.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Collections {
    public static void main(String[] args) {
        final List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        final boolean b = strings.removeIf(s -> s.length() > 4);
        System.out.println(strings.stream().collect(Collectors.joining(", ")));

        strings.replaceAll(String::toUpperCase);
        System.out.println(strings.stream().collect(Collectors.joining(", ")));

        strings.sort(Comparator.naturalOrder());
        System.out.println(strings.stream().collect(Collectors.joining(", ")));
    }
}
