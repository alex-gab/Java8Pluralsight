package com.alex.dataandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public final class ZonedTimeTest {

    public static void main(String[] args) {
        final Set<String> allZones = ZoneId.getAvailableZoneIds();
//        allZones.forEach(System.out::println);

        final ZonedDateTime currentMeeting = ZonedDateTime.of(
                LocalDate.of(2017, Month.MARCH, 12),
                LocalTime.of(9, 30),
                ZoneId.of("Europe/London"));
        System.out.println(currentMeeting);

        final ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));
        System.out.println(nextMeeting + "\n\n");

        final ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
        System.out.println(nextMeetingUS);
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
        System.out.println(DateTimeFormatter.ofPattern("yyMMdd").format(nextMeetingUS));
    }
}
