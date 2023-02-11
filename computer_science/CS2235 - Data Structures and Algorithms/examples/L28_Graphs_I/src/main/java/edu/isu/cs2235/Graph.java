package edu.isu.cs2235l20;

public interface Graph {

    void addVertex(int item);
    void removeVertex(int item);
    void addEdge(int u, int v);
    void removeEdge(int u, int v);
    int getNumV();
    int getNumE();
    boolean isDirected();
    boolean isEmpty();

}
