package org.sho.format.string;

public class FormatString {

    public static void main(String[] args) {

        System.out.println(String.format("%06.2f", 0.12356));

        String format = String.format("%d %<d %2$d", 100, 200, 300);
        System.out.println(format);

        // conversion to hexadecimal (base 16)
        System.out.println("\nConversion to hexadecimal:"); // prints: 20
        System.out.println(String.format("%x", 32)); // prints: 20
        // using the pound flag '#'
        System.out.println(String.format("%#x", 32)); // prints: 0x20
        System.out.println(String.format("%#X", 32)); // prints: 0X20

        // https://dzone.com/articles/java-string-format-examples

        // specify a width to right-justify
        System.out.println(String.format("|%20d|", 93)); // prints: | 93|
        // specify a width to left-justify
        System.out.println(String.format("|%-20d|", 93)); // prints: | 93|

        System.out.println(String.format("|%30s|", "Hello World")); // prints: | Hello World|
        System.out.println(String.format("|%-30s|", "Hello World")); // prints: |Hello World |
    }
}
