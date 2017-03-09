package com.alex.generics.comparable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Maximum {
    public static void main(String[] args) {
        final List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(max(ints));
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> elements) {
        final Iterator<? extends T> it = elements.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            final T el = it.next();
            if (el.compareTo(candidate) > 0) {
                candidate = el;
            }
        }

        return candidate;
    }
}
