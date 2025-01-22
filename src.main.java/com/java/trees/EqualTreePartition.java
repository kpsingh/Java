package com.java.trees;

import java.util.HashSet;

public class EqualTreePartition {

    public int equalTreePartition(TreeNode root, HashSet<Integer> set) {
        if(root == null)
            return 0;
        int sum = root.val + equalTreePartition(root.left, set) + equalTreePartition(root.right, set);
        set.add(sum);
        return sum;
    }
}
