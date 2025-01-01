package com.java.trees;

import java.util.ArrayList;
import java.util.List;

import static com.java.trees.TopViewOfBinaryTree.topViewOfBinaryTree;
import static com.java.trees.VerticalOrderOfBinaryTree.verticalOrder;


public class TestUtil {
    public static TreeNode getRoot() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        return root;
    }
}
