package org.sho.stream.parallel;

import java.util.Arrays;
import java.util.List;

public class Reduction {

    public static void main(String[] args) {

        String reduceOne = List.of("w", "o", "l", "f").stream().parallel()
            .reduce("", String::concat);
        System.out.println("ReduceOne: " + reduceOne);

        String reduceTwo = List.of('w', 'o', 'l', 'f', 'w', 'o', 'l', 'f', 'w', 'o', 'l', 'f').stream().parallel()
            .reduce("", (s1, c) ->
            {
                System.out.println(String.format("Acc - s1: %s, c: %s", s1, c));
                return s1 + c;
            }, (s2, s3) -> {
                System.out.println(String.format("Comb - s2: %s, s3: %s", s2, s3));
                return s2 + s3;
            } );
        System.out.println("ReduceTwo: " + reduceTwo);

        // Integer reduceThree = List.of(1,2,3,4,5,6)
        Integer reduceThree = List.of(1,2,3)
            .parallelStream()
            .reduce(0, (a, b) -> (a - b));
        System.out.println("ReduceThree: " + reduceThree);

        String[] grades = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        StringBuilder concat = Arrays.stream(grades).parallel()
                .reduce(new StringBuilder(),
                        (sb, s) -> new StringBuilder(sb).append(s),
                        (sb1, sb2) -> new StringBuilder(sb1).append(sb2));

        System.out.println(concat);
    }
}
