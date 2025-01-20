package com.java.trees;

import com.sun.source.tree.Tree;

public class DistanceBetweenNodesOfBST {

    public int distanceBetweenNodes(TreeNode root, int B, int C) {
        if (root == null || B == C) return 0;

        //calculate the LCA
        TreeNode lca = findLCA(root, B, C);
        int distance1 = findNode(lca, B);
        int distance2 = findNode(lca, C);

        return distance1 - distance2;
    }

    private int findNode(TreeNode root, int b) {
        int distance = 0;
        while (root != null) {
            if (root.val == b)
                return distance;

            distance++;
            if (root.val < b) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return distance;
    }

    private TreeNode findLCA(TreeNode root, int B, int C) {
        if (root == null) return null;
        if (root.val > B && root.val > C) return findLCA(root.left, B, C);
        else if (root.val < B && root.val > C) {
            return findLCA(root.right, B, C);
        } else {
            return root;
        }
    }
}
