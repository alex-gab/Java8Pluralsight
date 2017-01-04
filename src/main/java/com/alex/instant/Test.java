package com.alex.instant;

import java.time.Duration;
import java.time.Instant;

public final class Test {
    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("long computations here");
        Instant end = Instant.now();
        System.out.println(start);
        System.out.println(end);

        Duration elapsed = Duration.between(start, end);
        System.out.println(elapsed.toMillis());
    }
}
