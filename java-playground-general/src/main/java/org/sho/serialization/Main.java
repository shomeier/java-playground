package org.sho.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final String FILE_NAME = "./out.ser";

    public static void main(String[] args) throws Exception {

        printCwd();

        Book book = new Book();
        book.setBookName("Java Reference");
        book.setDescription("will not be saved");
        book.setCopies(25);
        System.out.println("Description of original book: " + book.getDescription());

        serialize(book);

        Book deserializedBook = deserialize();
        System.out.println("Description of deserialized book: " + deserializedBook.getDescription());
        System.out.println("Category of deserialized book: " + deserializedBook.getBookCategory());
        System.out.println("CategoryNewOperator of deserialized book: " + deserializedBook.getBookCategoryNewOperator());
    }

    private static void printCwd() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
    }

    public static void serialize(Book book) throws Exception {
        FileOutputStream file = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(book);
        out.close();
        file.close();
    }

    public static Book deserialize() throws Exception {
        FileInputStream file = new FileInputStream(FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(file);
        Book book = (Book) in.readObject();
        in.close();
        file.close();
        return book;
    }
}
