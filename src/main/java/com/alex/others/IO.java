package com.alex.others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class IO {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("src", "main", "resources", "people.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(l -> l.contains("Allan")).
                    findFirst().
                    ifPresent(System.out::println);
        }
    }
}
