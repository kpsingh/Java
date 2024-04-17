package com.java.multithreading.V3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService service;

    public TreeSizeCalculator(Node root, ExecutorService service) {
        this.root = root;
        this.service = service;
    }

    public Integer call() throws ExecutionException, InterruptedException {
        if (root == null) {
            return 0;
        }

        TreeSizeCalculator leftTree = new TreeSizeCalculator(root.left, service);
        TreeSizeCalculator rightTree = new TreeSizeCalculator(root.right, service);

        Future<Integer> leftFuture = service.submit(leftTree);
        Future<Integer> rightFuture = service.submit(rightTree);

        int left = leftFuture.get();
        int right = rightFuture.get();

        return 1 + left + right;

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}