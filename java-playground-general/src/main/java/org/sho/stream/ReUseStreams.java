package org.sho.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReUseStreams {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("./");
        System.out.println("Path we are operating on: " + path.toAbsolutePath().toString());

        Stream<Path> stream = Files.walk(path);

        long count = stream.count();
        System.out.println("Count: " + count);

        // java.lang.IllegalStateException: stream has already been operated upon or closed
        long countDirs = stream
            .filter(Files::isDirectory)
            .count();
        System.out.println("CountDirs: " + countDirs);

    }
}
