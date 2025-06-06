package com.java.trees;

import java.util.*;

public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TestUtil.getRoot();
        ArrayList<Integer> lists = topViewOfBinaryTree(root);
        System.out.println(lists);
    }
    public static ArrayList<Integer> topViewOfBinaryTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // tree map to store sorted order of distance
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>(); // q to do the level order traversal
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int d = pair.d;
            if (!map.containsKey(d)) {
               map.put(d, node.val);
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, d - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, d + 1));
            }
        }
        for(Integer key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}

