package org.sho.serialization;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = -2936687026040726549L;
    private String bookName;
    private transient String description;

    // final transient with literal initialization
    // see: https://www.baeldung.com/java-transient-keyword
    private final transient String bookCategory = "Fiction";
    // final transient with new operator
    private final transient String bookCategoryNewOperator = new String("Fiction with new Operator");

    public String getBookCategoryNewOperator() {
        return bookCategoryNewOperator;
    }
    public String getBookCategory() {
        return bookCategory;
    }
    private transient int copies;

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }
}
