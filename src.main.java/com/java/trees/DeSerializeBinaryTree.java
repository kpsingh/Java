package com.java.trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class DeSerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = deserialize(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));

    }

    public static TreeNode deserialize(List<Integer> data) {
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(i));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            i++;
            if (data.get(i) != -1) {
                TreeNode left = new TreeNode(data.get(i));
                queue.add(left);
                node.left = left;
            }
            i++;
            if (data.get(i) != -1) {
                TreeNode right = new TreeNode(data.get(i));
                queue.add(right);
                node.right = right;
            }
        }

        return root;

    }
}
