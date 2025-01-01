package com.java.trees;

import java.util.*;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TestUtil.getRoot();
        ArrayList<Integer> serialize = serialize(root);
        System.out.println(serialize);
    }

    public static ArrayList<Integer> serialize(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp != null){
                result.add(temp.val);
                q.add(temp.left);
                q.add(temp.right);
            }else{
                result.add(-1);
            }
        }
        return result;
    }
}
