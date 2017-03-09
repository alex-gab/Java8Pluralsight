package com.alex.generics;

import java.util.ArrayList;
import java.util.List;

public final class RestrictionsWildcards<E> {
    public ArrayList<E> list() {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") List<?> list = new ArrayList<E>();
        final Object o = list.get(1);
        return new ArrayList<>();
    }
}
