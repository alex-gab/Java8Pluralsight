package com.alex.masteringlambdas.taggedarray;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class TaggedArray<T> {
    private final Object[] elements; // immutable after construction

    public TaggedArray(T[] data, Object[] tags) {
        int size = data.length;
        if (tags.length != size) throw new IllegalArgumentException();
        this.elements = new Object[2 * size];
        for (int i = 0, j = 0; i < size; ++i) {
            elements[j++] = data[i];
            elements[j++] = tags[i];
        }
    }

    public Stream<T> stream() {
        return StreamSupport.stream(new TaggedArraySpliterator<>(elements, 0, elements.length), true);
    }
}
