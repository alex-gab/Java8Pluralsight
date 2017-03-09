package com.alex.masteringlambdas.library;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public final class Book {
    private final String title;
    private final List<String> authors;
    private final int[] pageCounts;
    private final Topic topic;
    private final Year pubDate;
    private final double height;

    public Book(String title, List<String> authors, int[] pageCounts, Year pubDate, double height, Topic topic) {
        this.title = title;
        this.authors = authors;
        this.pageCounts = pageCounts;
        this.topic = topic;
        this.pubDate = pubDate;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    public Topic getTopic() {
        return topic;
    }

    public Year getPubDate() {
        return pubDate;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", pageCounts=" + Arrays.toString(pageCounts) +
                ", topic=" + topic +
                ", pubDate=" + pubDate +
                ", height=" + height +
                '}';
    }
}
