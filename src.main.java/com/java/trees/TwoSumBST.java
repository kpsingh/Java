package com.java.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoSumBST {
    public int t2Sum(TreeNode A, int B) {
        // Stacks for in-order and reverse in-order traversal
        Deque<TreeNode> increasingStack = new ArrayDeque<>();
        Deque<TreeNode> decreasingStack = new ArrayDeque<>();

        // Initialize both stacks
        populateIncreasingStack(A, increasingStack);
        populateDecreasingStack(A, decreasingStack);

        while (!increasingStack.isEmpty() && !decreasingStack.isEmpty()) {
            TreeNode minNode = increasingStack.peek();
            TreeNode maxNode = decreasingStack.peek();

            // If both stacks point to the same node, stop
            if (minNode == maxNode) break;

            int sum = minNode.val + maxNode.val;

            if (sum == B) {
                return 1; // Pair found
            } else if (sum < B) {
                // Move the in-order pointer forward
                increasingStack.pop();
                populateIncreasingStack(minNode.right, increasingStack);
            } else {
                // Move the reverse in-order pointer backward
                decreasingStack.pop();
                populateDecreasingStack(maxNode.left, decreasingStack);
            }
        }
        return 0; // No pair found
    }

    // Populate stack for in-order traversal
    private void populateIncreasingStack(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Populate stack for reverse in-order traversal
    private void populateDecreasingStack(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }
}
