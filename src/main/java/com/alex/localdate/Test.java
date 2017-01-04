package com.alex.localdate;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static java.time.temporal.ChronoUnit.DAYS;

public final class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
//        System.out.println(now);
//        System.out.println(now.getDayOfYear());

        final LocalDate dateOfBirth = LocalDate.of(1564, Month.APRIL, 23);
//        System.out.println(dateOfBirth);

        final Period p = dateOfBirth.until(now);
//        System.out.println(p.getYears());

        final LocalDate swwStart = LocalDate.of(1939, Month.SEPTEMBER, 1);
//        System.out.println(swwStart.until(now).getYears());
//        System.out.println(swwStart.until(now).getDays());
        System.out.println(swwStart.until(now, DAYS));
    }
}
