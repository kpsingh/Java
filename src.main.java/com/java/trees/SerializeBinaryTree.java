package com.java.trees;

import java.util.*;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TestUtil.getRoot();
        ArrayList<Integer> serialize = serialize(root);
        System.out.println(serialize);
    }

    public static ArrayList<Integer> serialize(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            ans.add(tempNode.val);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            } else {
                if (tempNode.val != -1) queue.add(new TreeNode(-1));
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            } else {
                if (tempNode.val != -1) queue.add(new TreeNode(-1));
            }
        }
        return ans;
    }
}
