package edu.isu.cs.cs2263.library;

import java.util.Calendar;
import java.util.Iterator;

public class Library {

    public static final int EXIT               = 0;
    public static final int ADD_MEMBER         = 1;
    public static final int ADD_BOOKS          = 2;
    public static final int ISSUE_BOOKS        = 3;
    public static final int RETURN_BOOKS       = 4;
    public static final int RENEW_BOOKS        = 5;
    public static final int REMOVE_BOOKS       = 6;
    public static final int PLACE_HOLD         = 7;
    public static final int REMOVE_HOLD        = 8;
    public static final int PROCESS_HOLDS      = 9;
    public static final int PRINT_TRANSACTIONS = 10;
    public static final int SAVE_DATA          = 11;
    public static final int LOAD_DATA          = 12;
    public static final int HELP               = 13;

    private MemberList members;
    private Catalog books;

    private Library() {
        members = MemberList.instance();
        books = Catalog.instance();
    }

    public static Library instance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Library INSTANCE = new Library();
    }

    public Book addBook(String title, String author, String id) {
        Book book = new Book(title, author, id);
        if (books.insertBook(book)) {
            return book;
        }
        return null;
    }

    public Member addMember(String name, String address, String phone) {
        throw new RuntimeException();
    }

    public Book issueBook(String bookId, String memberId) {
        Book book = books.search(bookId);
        if (book == null)
            return null;
        if (book.getBorrower() != null)
            return null;
        Member member = members.search(memberId);
        if (member == null)
            return null;
        if (!(book.issue(member) && member.issue(book)))
            return null;
        return book;
    }

    public int returnBook(String bookId) {
        throw new RuntimeException();
    }

    public int removeBook(String bookId) {
        throw new RuntimeException();
    }

    public int placeHold(String memberId) {
        throw new RuntimeException();
    }

    public Member processHolds(String bookId) {
        throw new RuntimeException();
    }

    public int removeHold(String memberId, String bookId) {
        throw new RuntimeException();
    }

    public Member searchMembership(String memberId) {
        throw new RuntimeException();
    }

    public Book renewBook(String memberId, String bookId) {
        throw new RuntimeException();
    }

    public Iterator<Transaction> getTransactions(String memberId, Calendar date) {
        throw new RuntimeException();
    }

    public Iterator<Book> getBooks(String memberId) {
        throw new RuntimeException();
    }
}
