package org.sho.equals;

import java.util.Objects;

public class Equals {

    public static void main(String[] args) {

        String s1 = new String("Test");
        String s2 = new String("Test");

        System.out.println("s1 == s2: " + s1 == s2); // false
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true

        // Avoid NPEs like that:
        System.out.println("s1.equals(null): " + s1.equals(null));
        System.out.println("Objects.equals(s1, null): " + Objects.equals(s1, null));
        System.out.println("Objects.equals(null, s1): " + Objects.equals(null, s1));
        System.out.println("Objects.equals(null, null): " + Objects.equals(null, null));
    }
}
