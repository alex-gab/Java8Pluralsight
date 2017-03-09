package com.alex.masteringlambdas.collector;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("Duplicates")
public final class PointGroupingCollector {
    private static final int MAX_DISTANCE = 2;

    public static void main(String[] args) {
        final List<Point> points = IntStream.of(3, 6, 8, 10, 14).mapToObj(Point::new).sorted().collect(toList());
        final Deque<Deque<Point>> grouped = iterativeGroupByProximity(points);
        System.out.println(grouped);

        Supplier<Deque<Deque<Point>>> supplier =
                () -> {
                    Deque<Deque<Point>> segments = new ArrayDeque<>();
                    segments.add(new ArrayDeque<>());
                    return segments;
                };

        BiConsumer<Deque<Deque<Point>>, Point> accumulator =
                (queue, p) -> {
                    final Deque<Point> lastSegment = queue.getLast();
                    if (!lastSegment.isEmpty() && lastSegment.getLast().distance(p) > MAX_DISTANCE) {
                        final Deque<Point> newSegment = new ArrayDeque<>();
                        newSegment.add(p);
                        queue.add(newSegment);
                    } else {
                        lastSegment.add(p);
                    }
                };

        BinaryOperator<Deque<Deque<Point>>> combiner =
                (left, right) -> {
                    final Deque<Point> leftLast = left.getLast();
                    if (leftLast.isEmpty()) {
                        return right;
                    }
                    final Deque<Point> rightFirst = right.getFirst();
                    if (rightFirst.isEmpty()) {
                        return left;
                    }

                    if (leftLast.getLast().distance(rightFirst.getFirst()) <= MAX_DISTANCE) {
                        leftLast.addAll(rightFirst);
                        rightFirst.removeFirst();
                    }
                    left.addAll(right);
                    return left;
                };


        Collector<Point, Deque<Deque<Point>>, Deque<Deque<Point>>> segmentCollector = Collector.of(supplier, accumulator, combiner);

        System.out.println("******************************");

        IntStream.of(3, 6, 8, 10, 14).mapToObj(Point::new).sorted().collect(segmentCollector).forEach(System.out::println);

    }

    private static Deque<Deque<Point>> iterativeGroupByProximity(List<Point> points) {
        final Deque<Deque<Point>> grouped = new ArrayDeque<>();
        grouped.add(new ArrayDeque<>());

        for (Point p : points) {
            final Deque<Point> lastSegment = grouped.getLast();
            if (!lastSegment.isEmpty() && lastSegment.getLast().distance(p) > MAX_DISTANCE) {
                final Deque<Point> nextSegment = new ArrayDeque<>();
                nextSegment.add(p);
                grouped.add(nextSegment);
            } else {
                lastSegment.add(p);
            }
        }

        return grouped;
    }


}
