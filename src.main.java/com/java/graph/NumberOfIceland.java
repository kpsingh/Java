package com.java.graph;

public class NumberOfIceland {
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

    private static void bfs(int[][] a, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || visited[i][j] || a[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        // now explore all the 8 side from the current (i, j) position.
        bfs(a, visited, i - 1, j);
        bfs(a, visited, i + 1, j);
        bfs(a, visited, i, j - 1);
        bfs(a, visited, i, j + 1);
        bfs(a, visited, i - 1, j - 1);
        bfs(a, visited, i + 1, j + 1);
        bfs(a, visited, i - 1, j + 1);
        bfs(a, visited, i + 1, j - 1);


    }
}
