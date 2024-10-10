package org.sho.path;

import java.nio.file.Path;

public class MyPath {


    public static void main(String[] args) {

        Path first = Path.of("a/b");
        Path second = Path.of("a/b/c/d");
        Path relative = first.relativize(second);

        System.out.println("Relative path: " + relative);
    }
}
