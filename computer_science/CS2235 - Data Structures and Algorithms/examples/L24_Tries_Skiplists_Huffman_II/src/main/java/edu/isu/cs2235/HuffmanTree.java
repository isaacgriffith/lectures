package edu.isu.cs2235;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {

    Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public static HuffmanTree build(Map<String, Double> freqs) {
        Queue<Node> q = new PriorityQueue<>();
        freqs.forEach((k, v) -> q.offer(new Node(k, v)));

        int count = 1;
        while (q.size() > 1) {
            Node first = q.poll();
            Node second = q.poll();

            Node z = new Node("n" + count++, first.freq + second.freq);
            z.setLeft(first);
            z.setRight(second);
            q.offer(z);
        }

        HuffmanTree t = new HuffmanTree();
        t.setRoot(q.poll());
        return t;
    }

    public Map<Character, String> getCodes() {
        Map<Character, String> codes = new HashMap<>();
        getCodes(codes, root, "");
        return codes;
    }

    private void getCodes(Map<Character, String> map, Node node, String code) {
        if (node.getLeft() == null && node.getRight() == null) {
            map.put(node.label.charAt(0), code);
        }
        else {
            getCodes(map, node.getLeft(), code + "0");
            getCodes(map, node.getRight(), code + "1");
        }
    }
}

class Node implements Comparable<Node> {
    private Node parent, left, right;

    String label;
    double freq;

    public Node(String label, double freq) {
        this.label = label;
        this.freq = freq;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.setParent(this);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        right.setParent(this);
    }

    @Override
    public int compareTo(Node node) {
        return Double.compare(this.freq, node.freq);
    }
}