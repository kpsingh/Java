package com.java.trees;

import java.util.*;

public class DeSerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = deserialize(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));

    }

    public static TreeNode deserialize(List<Integer> data) {
        Queue<Pair> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode temp = pair.node;
            int d = pair.d;
            int leftChild = 2 * d + 1;
            int rightChild = 2 * d + 2;
            if(data.get(leftChild) != -1){
                TreeNode leftChildNode = new TreeNode(data.get(leftChild));
                temp.left = leftChildNode;
                queue.offer(new Pair(leftChildNode, leftChild));
            }
            if(data.get(rightChild) != -1){
                TreeNode rightChildNode = new TreeNode(data.get(rightChild));
                temp.right = rightChildNode;
                queue.offer(new Pair(rightChildNode, rightChild));
            }

        }
        return root;
    }
}
