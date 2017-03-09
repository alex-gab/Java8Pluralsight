package com.alex.masteringlambdas.exceptions;

import java.io.IOException;
import java.nio.file.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class ExceptionsExample {
    public static void main(String[] args) throws IOException {
        final Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        final PathMatcher testFileMatcher = FileSystems.getDefault().getPathMatcher("**/test*.txt");

        try (Stream<Path> pathStream = Files.walk(Paths.get("some"))) {
            pathStream.filter(testFileMatcher::matches).
                    flatMap(ExceptionsExample::lines).
                    filter(not(String::isEmpty)).
                    filter(l -> pattern.matcher(l).find()).
                    forEach(System.out::println);
        }
    }

    private static Stream<String> lines(Path p) {
        Stream<String> lines;
        try {
            lines = Files.readAllLines(p).stream();
        } catch (IOException e) {
            return Stream.of("");
        }
        return lines;
    }

    private static <T> Predicate<T> not(Predicate<T> p) {
        return p.negate();
    }
}


