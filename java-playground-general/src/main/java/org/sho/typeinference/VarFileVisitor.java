package org.sho.typeinference;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class VarFileVisitor {

    public static void main(String[] args) {

        var visitor = new FileVisitor<Path>() {

            private long countFiles = 0;
            private long countDirs = 0;

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                countDirs++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                // TODO Auto-generated method stub
                return FileVisitResult.CONTINUE;
            }
        };

        // thx to local variable type inference we can access the fields here
        // see also: https://developer.oracle.com/java/jdk-10-local-variable-type-inference.html (scroll down to "Type Inference with Non-Denotable Types")
        System.out.println("Count Files = " + visitor.countFiles);
        System.out.println("Count Dirs = " + visitor.countDirs);

    }
}
