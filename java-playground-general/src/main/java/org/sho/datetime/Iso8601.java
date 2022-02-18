package org.sho.datetime;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Iso8601 {

    private static String DATE_TIME = "2016-01-25T13:33Z";
    private static String DATE_TIME_2 = "2011-12-03T10:15:30+01:00";
    public static void main(String args[]) {

        OffsetDateTime dateTime1 = OffsetDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(DATE_TIME));
        OffsetDateTime dateTime2 = OffsetDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(DATE_TIME_2));
        // OffsetDateTime dateTime2 = (OffsetDateTime) DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(DATE_TIME_2);

        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }
}
