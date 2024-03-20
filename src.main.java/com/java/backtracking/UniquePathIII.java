package com.java.backtracking;

public class UniquePathIII {
    public static void main(String[] args) {
        UniquePathIII uniquePath = new UniquePathIII();
        int[][] arr = { {1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 2, -1}};
        int result = uniquePath.solve(arr);
        System.out.println("Total Path : " + result);
    }

    int ans= 0;
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        boolean[][] visited = new boolean[n][m]; // default all are false

        // try to find out starting point and count all non-obstacles squares
        int start_i = -1;
        int start_j = -1;
        int nonObstacles = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    nonObstacles++;
                }
                if (A[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                }
            }
        }

        backTrack(A, start_i, start_j, n, m, nonObstacles, visited, 0);
        return ans;

    }

    private void backTrack(int[][] arr, int startI, int startJ, int n, int m, int nonObstacles, boolean[][] visited, int count) {
        if (startI < 0 || startI >= n || startJ < 0 || startJ >= m || arr[startI][startJ] == -1 || visited[startI][startJ]) {
            return;
        }
        if (arr[startI][startJ] == 2) {
            if (count == nonObstacles) {
                ans++;
            }
            return;
        }

        visited[startI][startJ] = true;
        // explore the all 4 option from this position
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            backTrack(arr, startI + dir[0], startJ + dir[1], n, m, nonObstacles, visited, count+1);
        }
        visited[startI][startJ] = false;
    }
}
