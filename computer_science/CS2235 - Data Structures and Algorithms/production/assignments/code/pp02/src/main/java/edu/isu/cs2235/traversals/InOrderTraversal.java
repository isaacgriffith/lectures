package edu.isu.cs2235.traversals;

import csci132.structures.Node;
import csci132.structures.Tree;
import csci132.structures.impl.AbstractBinaryTree;
import java.util.List;

/**
 * A recursive implementation of the inorder tree traversal algorithm.
 *
 * @author Isaac Griffith
 * @param <E> The type of data in the tree to be traversed
 */
public class InOrderTraversal<E> extends DepthFirstTraversal<E> {

    /**
     * Constructs a new InOrder tree traversal for the given tree.
     *
     * @param tree Tree to be traversed.
     * @throws IllegalArgumentException If the type of tree to be traversed is
     * not a subtype of AbstractBinaryTree
     */
    public InOrderTraversal(Tree<E> tree) throws IllegalArgumentException {
        super(tree);
        if (!(tree instanceof AbstractBinaryTree)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void subtree(Node<E> p, List<Node<E>> snapshot) {
        throw new UnsupportedOperationException();
    }
}
