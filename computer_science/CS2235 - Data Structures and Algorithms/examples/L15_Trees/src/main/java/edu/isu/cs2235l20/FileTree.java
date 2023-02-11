package edu.isu.cs2235l20;

import java.util.ArrayList;

public class FileTree {

    private Node root;
    private Node current;
    private String location;

    public FileTree() {
        root = new Node("H:");
        location = root.getName();
        current = root;
    }

    public String getLocation() {
        return location;
    }

    public boolean moveDown(String file) {
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            if (file.equals(c.getName())) {
                current = c;
                location += "\\" + current.getName();
                return true;
            }
        }
        //for (int c = 0; c < children.size(); c++) {
        //    children.get(c).
        //}
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
            int index = location.lastIndexOf("\\");
            location = location.substring(0, index);
        }
    }

    public void goHome() {
        current = root;
        location = current.getName();

        //if no root pointer
        //while (current.getParent() != null) {
        //    current = current.getParent();
        //}
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        if (children != null) {     //check for null not actually needed by for-each loop
            for (Node c : children) {
                files += c.getName() + " ";
            }
        }
        return files;
    }

    public boolean insert(String file) {
        if (file != null && !file.equals(" ")) {
            Node newFile = new Node(file);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }

    public boolean remove(String file) {
        if (file != null) {
            ArrayList<Node> children = current.getChildren();
            for (Node c : children) {
                if (c.getName().equals(file)) {
                    children.remove(c);
                    return true;
                }
            }
        }
        return false;
    }
}
