package org.sho.regex;

public class ReplaceAll {

    public static void main(String[] args) {

        String replaceAll = "de-DE".replaceAll("(\\w)-(\\w)", "$1_$2");

        System.out.println("ReplaceAll: " + replaceAll);
    }
}
