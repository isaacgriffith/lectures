package edu.isu.cs.cs2263.library;

import java.util.Calendar;

public class Hold {

    private Calendar date;
    private Member member;
    private Book book;

    public Hold(Member member, Book book, Calendar date) {
        this.member = member;
        this.book = book;
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public boolean isValid() {
        throw new RuntimeException();
    }
}
