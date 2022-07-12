package org.sho.equals;

public class Equals {

    public static void main(String[] args) {

        String s1 = new String("Test");
        String s2 = new String("Test");

        System.out.println("s1 == s2: " + s1 == s2); // false
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true

        System.out.println("s1.equals(null): " + s1.equals(null));
    }
}
