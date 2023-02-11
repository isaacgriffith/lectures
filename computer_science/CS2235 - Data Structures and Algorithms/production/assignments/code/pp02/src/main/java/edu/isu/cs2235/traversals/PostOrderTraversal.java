package edu.isu.cs2235.traversals;

import csci132.structures.Node;
import csci132.structures.Tree;
import java.util.List;

/**
 * A recursive implementation of the PostOrder depthfirst traversal of a tree.
 *
 * @author Isaac Griffith
 * @param <E> The type of data stored in the tree to be traversed.
 */
public class PostOrderTraversal<E> extends DepthFirstTraversal<E> {

    /**
     * Constructs a new post order traversal for the provided tree
     *
     * @param tree The tree to traverse
     */
    public PostOrderTraversal(Tree<E> tree) {
        super(tree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void subtree(Node<E> p, List<Node<E>> snapshot) {
        throw new UnsupportedOperationException();
    }
}
