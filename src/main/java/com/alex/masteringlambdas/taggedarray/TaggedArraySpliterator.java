package com.alex.masteringlambdas.taggedarray;

import java.util.Spliterator;
import java.util.function.Consumer;

public final class TaggedArraySpliterator<T> implements Spliterator<T> {
    private final Object[] array;
    private int origin;
    private final int fence;

    public TaggedArraySpliterator(Object[] array, int origin, int fence) {
        this.array = array;
        this.origin = origin;
        this.fence = fence;
    }

    @Override
    public final boolean tryAdvance(Consumer<? super T> action) {
        if (origin < fence) {
            action.accept((T) array[origin]);
            origin += 2;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final Spliterator<T> trySplit() {
        int lo = origin;
        int mid = (fence + origin) >>> 1 & ~1;
        Spliterator<T> newSplit = null;
        if (lo < mid) {
            newSplit = new TaggedArraySpliterator<>(array, lo, mid);
            origin = mid;
        }
        return newSplit;
    }

    @Override
    public final long estimateSize() {
        return (fence - origin) / 2;
    }

    @Override
    public final int characteristics() {
        return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
    }
}
