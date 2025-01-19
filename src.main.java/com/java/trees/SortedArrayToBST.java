package com.java.trees;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        TreeNode root = constructBST(arr, 0, arr.length-1);
    }

    // Helper method to recursively construct the BST
    private static TreeNode constructBST(int[] arr, int low, int high) {
        // Base case: if the range is invalid, return null
        if (low > high) return null;

        // Find the middle element of the current range
        int mid = low + (high - low) / 2;

        // Create a new tree node with the middle element
        TreeNode root = new TreeNode(arr[mid]);

        // Recursively construct the left and right subtrees
        root.left = constructBST(arr, low, mid - 1);
        root.right = constructBST(arr, mid + 1, high);

        // Return the root of the constructed subtree
        return root;
    }
}
