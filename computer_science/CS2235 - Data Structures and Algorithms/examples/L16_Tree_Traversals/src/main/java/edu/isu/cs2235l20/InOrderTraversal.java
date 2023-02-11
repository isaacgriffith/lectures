package edu.isu.cs2235l20;

public class InOrderTraversal extends DepthFirstTraversal {

    public InOrderTraversal(Visitor cmd) {
        super(cmd);
    }

    @Override
    public void traverse(Node node) {
        if (node.getLeft() != null) {
            traverse(node);
        }
        cmd.execute(node);
        if (node.getRight() != null) {
            traverse(node);
        }
    }
}
