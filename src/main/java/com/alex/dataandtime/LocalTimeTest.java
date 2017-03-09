package com.alex.dataandtime;

import java.time.LocalTime;

public final class LocalTimeTest {
    public static void main(String[] args) {
        final LocalTime now = LocalTime.now();
        System.out.println(now);

        final LocalTime time = LocalTime.of(10, 20);
        System.out.println(time);

        final LocalTime bedTime = LocalTime.of(23, 0);
        final LocalTime wakeupTime = bedTime.plusHours(8);
        System.out.println(wakeupTime);
    }
}
