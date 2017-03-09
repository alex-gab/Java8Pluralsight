package com.alex.dataandtime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
public final class DataAndTime {
    public static void main(String[] args) {
        final ArrayList<Person> persons = new ArrayList<>();

        final URL resource = DataAndTime.class.getClassLoader().getResource("people.txt");
        try (final BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(new FileInputStream(resource.getFile())));
             final Stream<String> stream = reader.lines()) {
            stream.map(
                    line -> {
                        final String[] s = line.split(" ");
                        final String name = s[0].trim();
                        final int year = Integer.parseInt(s[1]);
                        final Month month = Month.of(Integer.parseInt(s[2]));
                        final int dayOfMonth = Integer.parseInt(s[3]);
                        Person p = new Person(name, LocalDate.of(year, month, dayOfMonth));
                        persons.add(p);
                        return p;
                    }
            ).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        final LocalDate now = LocalDate.now();
        persons.forEach(p -> {
            final Period period = Period.between(p.getDateOfBirth(), now);
            System.out.printf("%s was born %d years and %d months ago [%d months].\n",
                    p.getName(),
                    period.get(ChronoUnit.YEARS),
                    period.get(ChronoUnit.MONTHS),
                    p.getDateOfBirth().until(now, ChronoUnit.MONTHS));
        });
    }
}
