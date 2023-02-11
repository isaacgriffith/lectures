package edu.isu.cs2235l20;

import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        bst.insertRec(44);
//        bst.insertRec(17);
//        bst.insertRec(88);
//        bst.insertRec(8);
//        bst.insertRec(32);
//        bst.insertRec(65);
//        bst.insertRec(97);
//        bst.insertRec(28);
//        bst.insertRec(54);
//        bst.insertRec(82);
//        bst.insertRec(93);
//        bst.insertRec(21);
//        bst.insertRec(29);
//        bst.insertRec(76);
//        bst.insertRec(68);
//        bst.insertRec(80);

        bst.insertRec(19);
        bst.insertRec(13);
        bst.insertRec(22);
        bst.insertRec(11);
        bst.insertRec(15);
        bst.insertRec(25);
        bst.insertRec(27);
        bst.insertRec(38);

        //System.out.println(bst.search(19));

        PrintTree.printTree(bst);

        bst.postorder();

        Iterator itr = bst.iterator();
        if (itr.hasNext()) {
            System.out.print(itr.next());
        }
        while (itr.hasNext()) {
            System.out.print(", " + itr.next());
        }
        System.out.println();
    }
}