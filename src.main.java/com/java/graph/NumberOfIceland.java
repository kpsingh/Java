package com.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIceland {

    private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};


    public static void main(String[] args) {
        //int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] arr = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        int res = solve(arr);
        System.out.println(res);
    }

    public static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(A, visited, i, j);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] arr, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair cell = queue.poll();
            int i = cell.i, j = cell.j;

            for (int d = 0; d < 8; d++) {
                int ni = i + dx[d], nj = j + dy[d];
                if (isValid(arr, visited, ni, nj)) {
                    queue.add(new Pair(ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }
    }

    private static boolean isValid(int[][] arr, boolean[][] visited, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && arr[i][j] == 1 && !visited[i][j];
    }
}

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;

    }
}
