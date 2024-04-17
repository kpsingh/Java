package com.test.leetcode;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService service;

    TreeSizeCalculator(Node root, ExecutorService service){
        this.root = root;
        this.service = service;
    }


    @Override
    public Integer call() throws Exception {
        if (root == null)
            return 0;

        TreeSizeCalculator left = new TreeSizeCalculator(root.left, service);
        TreeSizeCalculator right = new TreeSizeCalculator(root.right, service);

        Future<Integer> leftHeightFuture = service.submit(left);
        Future<Integer> rightHeightFuture = service.submit(right);

        int leftHeight = leftHeightFuture.get();
        int rightHeight = rightHeightFuture.get();

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
