package cs.isu.edu.cs2263.practicum12;

import java.util.*;

public interface Deque {
    void addAtTail(Object value);

    Object removeElementAtTail();

    Object getElementAtTail();

    void addAtHead(Object value);

    Object removeElementAtHead();

    Object getElementAtHead();

    int size();

    void clear();

    Iterator iterator();
}
