package edu.isu.cs2235.traversals;

import csci132.structures.Node;
import csci132.structures.Tree;
import java.util.List;

/**
 * An implmentation of a DepthFirst PreOrder Traversal for a tree.
 *
 * @author Isaac Griffith
 * @param <E> The type of data stored in the tree to be traversed.
 */
public class PreOrderTraversal<E> extends DepthFirstTraversal<E> {

    /**
     * Constructs a new PreOrder traversal for the provided tree.
     *
     * @param tree Tree to be traversed.
     */
    public PreOrderTraversal(Tree<E> tree) {
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
