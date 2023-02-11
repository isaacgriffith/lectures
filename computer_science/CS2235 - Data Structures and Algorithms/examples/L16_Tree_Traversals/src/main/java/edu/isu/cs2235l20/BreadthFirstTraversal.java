package edu.isu.cs2235l20;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BreadthFirstTraversal implements TreeTraversal {

    private Visitor command;

    public BreadthFirstTraversal(Visitor cmd) {
        this.command = cmd;
    }

    public void traverse(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.getLeft() != null)
                q.add(curr.getLeft());
            if (curr.getRight() != null)
                q.add(curr.getRight());

            command.execute(curr);
        }
    }
}
