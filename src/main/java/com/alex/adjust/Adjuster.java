package com.alex.adjust;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public final class Adjuster {
    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        final LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(now);
        System.out.println(nextSunday);

        final LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
    }
}
