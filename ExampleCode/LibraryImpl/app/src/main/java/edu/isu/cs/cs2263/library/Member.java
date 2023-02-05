package edu.isu.cs.cs2263.library;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Member {

    private String name;
    private String address;
    private String phone;
    private List<Book> booksOnHold;
    private List<Book> booksBorrowed;
    private List<Transaction> transactions;
    private String id;

    public Member(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        booksOnHold = new LinkedList<>();
        transactions = new LinkedList<>();
        booksBorrowed = new LinkedList<>();
    }

    public boolean issue(Book book) {
        if (booksBorrowed.add(book)) {
            transactions.add(new Transaction("Book issued ", book.getTitle()));
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        throw new RuntimeException();
    }

    public boolean renew(Book book) {
        throw new RuntimeException();
    }

    public void placeHold(Hold hold) {
        throw new RuntimeException();
    }

    public void removeHold(String bookId) {
        throw new RuntimeException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public Iterator<Transaction> getTransactions(Calendar date) {
        throw new RuntimeException();
    }

    public Iterator<Book> getBooksIssued() {
        throw new RuntimeException();
    }
}
