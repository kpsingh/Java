package com.java.trees;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        List<List<Integer>> lists = verticalOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    private static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); // tree map to store sorted order of distance
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>(); // q to do the level order traversal
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int d = pair.d;
            map.putIfAbsent(d, new ArrayList<>()); // if first time then insert the linked list
            map.get(d).add(node.val);
            if (node.left != null) {
                queue.add(new Pair(node.left, d - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, d + 1));
            }

        }
        return new ArrayList<>(map.values());
    }
}

