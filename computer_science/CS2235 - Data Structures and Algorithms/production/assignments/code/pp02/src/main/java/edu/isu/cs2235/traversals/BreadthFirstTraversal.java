package edu.isu.cs2235.traversals;

import csci132.structures.Node;
import csci132.structures.Tree;
import csci132.traversals.commands.TraversalCommand;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An implementation of the Iterative BreadthFirstSearch algorithm.
 *
 * @author Isaac Griffith
 */
public class BreadthFirstTraversal<E> extends AbstractTraversal<E> {

    /**
     * Constructs a new BreadthFirst Traversal for the given tree.
     *
     * @param tree The tree to traverse
     */
    public BreadthFirstTraversal(Tree<E> tree) {
        super(tree);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Node<E>> traverse() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Node<E>> traverseFrom(Node start) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCommand(TraversalCommand cmd) {
        this.command = cmd;
    }
}
