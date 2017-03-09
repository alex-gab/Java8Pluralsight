package com.alex.masteringlambdas.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public final class Main {
    public static void main(String[] args) {
        final List<Book> library = Books.library();
        final Stream<Book> booksSortedByTitle = library.stream().
                sorted(Comparator.comparing(Book::getTitle));

        final Stream<Book> booksSortedByAuthorCount = library.stream().
                sorted(Comparator.comparing(Book::getAuthors, Comparator.comparing(List::size)));

        final ArrayList<?> objects = new ArrayList<Integer>();
    }
}
