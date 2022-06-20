package org.sho.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderDemo {

    public static void main(String[] args) throws URISyntaxException, IOException {

        // URL resource = BufferedReaderDemo.class.getResource("/org/sho/read/utf-8.txt");
        URL resource = BufferedReaderDemo.class.getResource("/org/sho/read/iso-8859-1.txt");
        Path path = Paths.get(resource.toURI());

        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)) {
            br.lines().forEach(System.out::println);
        }

        // UTF-8 also is default
        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            br.lines().forEach(System.out::println);
        }
    }
}
