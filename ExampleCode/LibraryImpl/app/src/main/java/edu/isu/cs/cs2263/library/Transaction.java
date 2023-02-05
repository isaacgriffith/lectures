package edu.isu.cs.cs2263.library;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transaction {

    private final String type;
    private final String title;
    private final Calendar date;

    public Transaction(String type, String title) {
        this.type = type;
        this.title = title;
        this.date = new GregorianCalendar();
        this.date.setTimeInMillis(System.currentTimeMillis());
    }

    public boolean onDate(Calendar date) {
        return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR)) &&
                (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH)) &&
                (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" +
               date.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return (type + "   " + title);
    }
}
