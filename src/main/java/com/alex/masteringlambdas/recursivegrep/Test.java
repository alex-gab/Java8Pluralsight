package com.alex.masteringlambdas.recursivegrep;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

import static java.nio.channels.FileChannel.MapMode.READ_ONLY;

public final class Test {
    public static void main(String[] args) throws IOException {
        final Pattern pattern = Pattern.compile("W.*t");

        final Path start = new File("file.txt").toPath();
        try (FileChannel fc = FileChannel.open(start)) {
            final MappedByteBuffer bB = fc.map(READ_ONLY, 0, fc.size());
            final LineSpliterator ls = new LineSpliterator(bB, 0, bB.limit() - 1);

            StreamSupport.stream(ls, true).
                    filter(dispLine -> pattern.matcher(dispLine.line).find()).
                    forEachOrdered(System.out::print);
        }
    }
}
