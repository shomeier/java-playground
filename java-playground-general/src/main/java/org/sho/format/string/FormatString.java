package org.sho.format.string;

public class FormatString {

    public static void main(String[] args) {

        String format = String.format("%d %<d %2$d", 100, 200, 300);
        System.out.println(format);
    }
}
