package com.alex.masteringlambdas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public final class Sources {
    public static void main(String[] args) {
        final Path start = new File(".").toPath();
        try (Stream<Path> pathStream = Files.walk(start)) {
            pathStream.
                    map(Path::toFile).
                    filter(File::isFile).
                    sorted(Comparator.comparing(File::length).reversed()).
                    map(f -> f.getAbsolutePath() + " " + f.length()).
                    forEachOrdered(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
