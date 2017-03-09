package com.alex.masteringlambdas.library;

import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.alex.masteringlambdas.library.Topic.*;

public final class Books {
    public static List<Book> library() {
        final Book nails = new Book("Fundamentals of Chinese Fingernail Image",
                Arrays.asList("Li", "Fu", "Li"),
                new int[]{256},
                Year.of(2014),
                25.2,
                MEDICINE);

        final Book dragon = new Book("Compilers; Principles, Techiques and Tools",
                Arrays.asList("Aho", "Lam", "Sethi", "Ullman"),
                new int[]{1009},
                Year.of(2006),
                23.6,
                COMPUTING);

        final Book voss = new Book("Voss",
                Collections.singletonList("Patrick White"),
                new int[]{478},
                Year.of(1957),
                19.8,
                FICTION);

        final Book lotr = new Book("Lord of the Rings",
                Collections.singletonList("Tolkien"),
                new int[]{531, 416, 624},
                Year.of(1955),
                23.0,
                FICTION);

        return Arrays.asList(nails, dragon, voss, lotr);
    }
}
