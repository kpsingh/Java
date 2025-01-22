package com.java.trees;

import com.sun.source.tree.Tree;

/*
https://leetcode.com/problems/path-sum/description/
112. Path Sum
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int target = 1;
        boolean result = hasPathSum(root, target);
        System.out.println(result);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}

