package com.alex.masteringlambdas.recursivegrep;

import java.nio.ByteBuffer;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class LineSpliterator implements Spliterator<DispLine> {
    private static final int AVG_LINE_LENGTH = 40;
    private ByteBuffer bb;
    private int lo, hi;

    public LineSpliterator(ByteBuffer bb, int lo, int hi) {
        this.bb = bb;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public boolean tryAdvance(Consumer<? super DispLine> action) {
        if (lo > hi) {
            return false;
        }
        final int mark = findFirstNewLine(lo);
        final StringBuffer sb = new StringBuffer();
        for (int i = lo; i <= mark; i++) {
            sb.append((char) bb.get(i));
        }
        action.accept(new DispLine(lo, sb.toString()));
        lo += sb.length();
        return true;
    }

//    public boolean tryAdvance(Consumer<? super DispLine> action) {
//        int index = lo;
//        StringBuilder sb = new StringBuilder();
//        do {
//            sb.append((char) bb.get(index));
//        } while (bb.get(index++) != '\n');
//        action.accept(new DispLine(lo, sb.toString()));
//        lo = lo + sb.length();
//        return lo <= hi;
//    }

    @Override
    public Spliterator<DispLine> trySplit() {
        final int half = findFirstNewLine((hi + lo) / 2);
        LineSpliterator newSplit = null;
        if (half != hi) {
            newSplit = new LineSpliterator(bb, lo, half);
            this.lo = half + 1;
        }
        return newSplit;
    }

//    @Override
//    public Spliterator<DispLine> trySplit() {
//        int index = (lo + hi) >>> 1;
//        while (bb.get(index) != '\n') index++;
//        LineSpliterator newSpliterator = null;
//        if (index != hi) {
//            newSpliterator = new LineSpliterator(bb, lo, index);
//            lo = index + 1;
//        }
//        return newSpliterator;
//    }

//    @Override
//    public void forEachRemaining(Consumer<? super DispLine> action) {
//        int index = lo;
//        StringBuilder sb = new StringBuilder();
//        while (index <= hi) {
//            do {
//                sb.append((char) bb.get(index));
//            } while (bb.get(index++) != '\n');
//            action.accept(new DispLine(lo, sb.toString()));
//            lo += sb.length();
//            sb.setLength(0);
//        }
//    }

    @Override
    public long estimateSize() {
        return (hi - lo + 1) / AVG_LINE_LENGTH;
    }

    @Override
    public int characteristics() {
        return ORDERED | IMMUTABLE | NONNULL;
    }

    private int findFirstNewLine(int beginIndex) {
        int candidate = beginIndex;
        while (bb.get(candidate) != '\n') {
            candidate++;
        }
        return candidate;
    }
}
