package org.sho.methodreference;

import java.util.Comparator;
import java.util.stream.*;

public class MethodReference {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream
            .sorted(Comparator.reverseOrder())
            // .sorted(Comparator::reverseOrder)
            .forEach(System.out::println);
    }
}
