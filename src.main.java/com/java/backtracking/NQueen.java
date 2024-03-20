package com.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        NQueen queen = new NQueen();
        ArrayList<ArrayList<String>> result = queen.solveNQueens(n);
        System.out.println(result);
    }

    private ArrayList<ArrayList<String>> solveNQueens(int n) {
        String[][] arr = new String[n][n];
        for (String[] a : arr) {
            Arrays.fill(a, ".");
        }
        int level = 0;

        solveNQueens(arr, n, level);
        return result;
    }

    private void solveNQueens(String[][] arr, int n, int level) {
        if (level == n) {
            captuePosition(arr);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (valid(arr, n, level, j)) {
                arr[level][j] = "Q";
                solveNQueens(arr, n, level + 1);
                arr[level][j] = ".";
            }
        }
    }

    private void captuePosition(String[][] arr) {
        ArrayList<String> position = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]);
            }
            position.add(sb.toString());
        }
        result.add(position);
    }

    private boolean valid(String[][] arr, int n, int level, int j) {
        // validate  top of current position
        int x = level - 1;
        int y = j;
        while (x >= 0) {
            if (arr[x][y] == "Q") {
                return false;
            }
            x--;
        }

        // validate left diagonal
        x = level - 1;
        y = j - 1;
        while (x >= 0 && y >= 0) {
            if (arr[x][y] == "Q") {
                return false;
            }
            x--;
            y--;
        }

        // validate the top right diagonal

        x = level - 1;
        y = j + 1;

        while (x >= 0 && y < n) {
            if (arr[x][y] == "Q") {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }
}
