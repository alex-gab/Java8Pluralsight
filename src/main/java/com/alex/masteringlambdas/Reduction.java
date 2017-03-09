package com.alex.masteringlambdas;

import com.alex.masteringlambdas.library.Book;
import com.alex.masteringlambdas.library.Books;
import com.alex.masteringlambdas.library.Topic;

import java.math.BigInteger;
import java.time.Year;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public final class Reduction {
    public static void main(String[] args) {
        final List<Book> library = Books.library();

        final IntSummaryStatistics pageCountStatistics = library.stream().
                mapToInt(b -> IntStream.of(b.getPageCounts()).sum()).
                summaryStatistics();
        System.out.println(pageCountStatistics);

        final Optional<Book> oldest = library.stream().
                min(Comparator.comparing(Book::getPubDate));
        oldest.ifPresent(System.out::println);

        final Map<String, Year> titleToPubDate = library.stream().
                collect(toMap(Book::getTitle, Book::getPubDate, (x, y) -> x.isAfter(y) ? x : y));
        titleToPubDate.forEach((k, v) -> System.out.printf("%s: %s\n", k, v));

        final List<String> authorsForBooks = library.stream().
                map(b -> b.getAuthors().stream().
                        collect(joining(", ", b.getTitle() + ": ", ""))).
                collect(toList());
        System.out.println(authorsForBooks);
        System.out.println(authorsForBooks.get(1));


        System.out.println("******************************************************************************************");
        final Map<Topic, Optional<Book>> mostAuthorsByTopic = library.stream().
                collect(groupingBy(Book::getTopic, maxBy(Comparator.comparing(b -> b.getAuthors().size()))));

        final Map<Topic, Integer> volumeCountByTopic = library.stream().
                collect(groupingBy(Book::getTopic, summingInt(b -> b.getPageCounts().length)));

        final Map<Topic, Double> averageHeightByTopic = library.stream().
                collect(groupingBy(Book::getTopic, averagingDouble(Book::getHeight)));

        final Map<Topic, Double> headroomByTopic = library.stream().
                collect(groupingBy(Book::getTopic, reducing(0.0d, Book::getHeight, Double::max)));
        System.out.println(headroomByTopic);

        final Map<Topic, Optional<Double>> maxHeightByTopic = library.stream().
                collect(groupingBy(Book::getTopic, mapping(Book::getHeight, maxBy(Comparator.naturalOrder()))));
        System.out.println(maxHeightByTopic);

        System.out.println("*******************mostPopularTopic***********************************************************");
        final Optional<Topic> mostPopularTopic = library.stream().
                collect(groupingBy(Book::getTopic, counting())).
                entrySet().stream().
                max(Entry.comparingByValue()).
                map(Entry::getKey);
        System.out.printf("most popular topic is: %s\n", mostPopularTopic);
        System.out.println("***********************mostPopularTopics******************************************************");
        final Optional<Set<Topic>> mostPopularTopics = library.stream().
                collect(groupingBy(Book::getTopic, counting())).
                entrySet().stream().
                collect(groupingBy(Entry::getValue, mapping(Entry::getKey, toSet()))).
                entrySet().stream().
                max(Entry.comparingByKey()).
                map(Entry::getValue);
        System.out.printf("most popular topics are: %s\n", mostPopularTopics);


        System.out.println("***********************reduce******************************************************");
        int factorial =
                IntStream.rangeClosed(1, 4).reduce(1, (a, b) -> a * b);
        System.out.println(factorial);
        final BigInteger fact = LongStream.rangeClosed(1, 4).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        System.out.println(fact);

        System.out.println("***********************indexedStreams******************************************************");
        library.stream().
                map(
                        book -> {
                            final int[] volumes = book.getPageCounts();
                            return IntStream.rangeClosed(1, volumes.length).
                                    mapToObj(i -> i + ":" + volumes[i - 1]).
                                    collect(joining(", ", book.getTitle() + ": ", ""));
                        }
                ).
                forEach(System.out::println);

    }
}
