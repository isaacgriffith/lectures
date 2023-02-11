package edu.isu.cs.cs2263.library;

import java.util.*;

public class Book {

    private Calendar dueDate;
    private String title;
    private String author;
    private String id;
    private Member borrowedBy;
    private List<Hold> holds;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
        holds = new LinkedList<>();
    }

    public boolean issue(Member member) {
        borrowedBy = member;
        dueDate = new GregorianCalendar();
        dueDate.setTimeInMillis(System.currentTimeMillis());
        dueDate.add(Calendar.MONTH, 1);
        return true;
    }

    public Member returnBook() {
        throw new RuntimeException();
    }

    public boolean renew(Member member) {
        throw new RuntimeException();
    }

    public void placeHold(Hold hold) {
        throw new RuntimeException();
    }

    public boolean removeHold(String memberId) {
        throw new RuntimeException();
    }

    public Hold getNextHold() {
        throw new RuntimeException();
    }

    public Iterator<Hold> getHolds() {
        throw new RuntimeException();
    }

    public boolean hasHold() {
        throw new RuntimeException();
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public Member getBorrower() {
        return borrowedBy;
    }
}
