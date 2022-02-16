package org.sho.datetime;

import java.time.format.DateTimeFormatter;

public class Iso8601 {

    private static String DATE_TIME = "2016-01-25T13:33:02Z";
    private static String DATE_TIME_2 = "2011-12-03T10:15:30+01:00";
    public static void main(String args[]) {

        var dateTime1 = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(DATE_TIME);
        var dateTime2 = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(DATE_TIME_2);

        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }
}
