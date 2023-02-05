package edu.isu.cs.cs2263.library;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Catalog {

    private List<Book> books;

    private Catalog() {
        books = new LinkedList<>();
    }

    public static Catalog instance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Catalog INSTANCE = new Catalog();
    }

    public Book search(String bookId) {
        throw new RuntimeException();
    }

    public boolean removeBook(String bookId) {
        throw new RuntimeException();
    }

    public boolean insertBook(Book book) {
        if (book != null)
            return books.add(book);
        return false;
    }

    public Iterator<Book> getBooks() {
        return books.iterator();
    }
}
