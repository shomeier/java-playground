package org.sho.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyVsFindFirst {

    public static void main(String ...args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // in non-parallel pipelines both (should) have the same behaviour (only affects parallel pipelines)
        System.out.println("FindAny...");
        Optional<Integer> result = list.stream()
        .filter(num -> num < 4)
        .peek(System.out::println)
        .findAny(); // only oputput is "1"

        System.out.println("FindFirst...");
        result = list.stream()
        .filter(num -> num < 4)
        .peek(System.out::println)
        .findFirst(); // only oputput is "1"
    }
}
