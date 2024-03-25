package com.java.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToHospital {
    public static void main(String[] args) {
        char[][] arr = {{'R', 'R', 'R', 'H'}, {'R', 'R', 'H', 'H'}, {'R', 'H', 'H', 'R'}};
        int[][] ans = findShortestPath(arr);
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }

    }

    private static int[][] findShortestPath(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] ans = new int[n][m];
        for (int[] a : ans) {
            Arrays.fill(a, -1);
        }
        Queue<Grid> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'H') {
                    ans[i][j] = 0;
                    q.add(new Grid(i, j));
                }
            }
        }

        int distance = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            distance++;
            for (int i = 0; i < level; i++) {
                Grid grid = q.poll();
                // check all 4 directional valid cells from a grid there is 4 move possible,
                int[] X = {0, -1, 0, 1};
                int[] Y = {1, 0, -1, 0};
                for (int k = 0; k < X.length; k++) {
                    int ni = grid.i + X[k];
                    int nj = grid.j + Y[k];
                    boolean isValidCell = isValid(ni, nj, ans);
                    if (isValidCell) {
                        ans[ni][nj] = distance;
                        q.add(new Grid(ni, nj));
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isValid(int ni, int nj, int[][] ans) {
        if (ni < 0 || ni >= ans.length || nj < 0 || nj >= ans.length || ans[ni][nj] != -1) {
            return false;
        }
        return true;
    }
}


