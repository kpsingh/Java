package com.java.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestInBST {
    public int kthsmallest(TreeNode root, int B) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == B) {
                return root.val;
            }
            root = root.right;
        }
        return -1;

    }
}
