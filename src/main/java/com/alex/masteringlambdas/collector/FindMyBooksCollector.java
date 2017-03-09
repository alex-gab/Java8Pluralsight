package com.alex.masteringlambdas.collector;

import com.alex.masteringlambdas.library.Book;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static com.alex.masteringlambdas.library.Books.library;
import static java.util.stream.Collectors.*;

public final class FindMyBooksCollector {
    public static void main(String[] args) {
        Supplier<Deque<DispRecord>> supplier = ArrayDeque::new;
        BiConsumer<Deque<DispRecord>, Book> accumulator =
                (records, b) -> {
                    final int disp = records.isEmpty() ? 0 : records.getLast().totalDisp();
                    final DispRecord newRecord = new DispRecord(b.getTitle(), disp, Arrays.stream(b.getPageCounts()).sum());
                    records.add(newRecord);
                };

        BinaryOperator<Deque<DispRecord>> combiner =
                (left, right) -> {
                    if (left.isEmpty()) {
                        return right;
                    }
                    final int newDisp = left.getLast().totalDisp();
                    final List<DispRecord> newRight = right.stream().
                            map(dr -> new DispRecord(dr.title, dr.disp + newDisp, dr.length)).
                            collect(toList());
                    left.addAll(newRight);
                    return left;
                };

        Function<Deque<DispRecord>, Map<String, Integer>> finisher =
                records -> records.parallelStream().collect(toConcurrentMap(dr -> dr.title, dr -> dr.disp));

        final Collector<Book, Deque<DispRecord>, Map<String, Integer>> displacementCollector =
                Collector.of(supplier, accumulator, combiner, finisher);

        Map<String, Integer> displacements = library().stream().
                collect(displacementCollector);
        System.out.println(displacements);

        displacements = library().stream().
                map(DispRecord::new).
                map(DispRecord::wrap).
                reduce(combiner).orElseGet(ArrayDeque::new).
                stream().
                collect(toMap(dr -> dr.title, dr -> dr.disp));
        System.out.println(displacements);


    }
}
