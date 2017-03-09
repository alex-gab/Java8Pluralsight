package com.alex.masteringlambdas.collector;

import com.alex.masteringlambdas.library.Book;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

final class DispRecord {
    final String title;
    final int disp, length;

    DispRecord(String title, int disp, int length) {
        this.title = title;
        this.disp = disp;
        this.length = length;
    }

    public DispRecord(Book b) {
        this(b.getTitle(), 0, IntStream.of(b.getPageCounts()).sum());
    }

    public Deque<DispRecord> wrap() {
        final ArrayDeque<DispRecord> ddr = new ArrayDeque<>();
        ddr.add(this);
        return ddr;
    }

    final int totalDisp() {
        return disp + length;
    }
}
