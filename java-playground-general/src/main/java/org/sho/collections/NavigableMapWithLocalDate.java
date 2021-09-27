package org.sho.collections;

import java.time.LocalDate;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapWithLocalDate {

    public static void main(String[] args) {

        NavigableMap<LocalDate, String> nm = new TreeMap<>();
        nm.put(LocalDate.now(), "x");
        nm.put(LocalDate.now().minusDays(1), "y");

        // LocalDate just represents year, month and day, thats why both LocalDate.now() are equal
        System.out.println(nm.lowerEntry(LocalDate.now()));
    }
}
