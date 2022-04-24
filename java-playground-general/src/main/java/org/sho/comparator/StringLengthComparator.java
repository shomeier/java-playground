package org.sho.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class StringLengthComparator {

    public static void main(String... args) {

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        // sort strings lexicographically
        Comparator<String> cmp = (s1, s2) -> s1.compareTo(s2);
        strings.sort(cmp);
        System.out.println(strings);

        // sort strings by their length
        Comparator<String> cmp2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        strings.sort(cmp2);
        System.out.println(strings);

        // sort strings by their length using a key extractor
        ToIntFunction<String> toLength = String::length;
        Comparator<String> cmp3 = Comparator.comparingInt(toLength);
        strings.sort(cmp3);
        System.out.println(strings);
    }

}
