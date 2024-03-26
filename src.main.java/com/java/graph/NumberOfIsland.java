package com.java.graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int result = numIslands(grid);
        System.out.println(result);
    }

    private static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int numberofIsland = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numberofIsland++;
                    dfs(i, j, n, m, grid, visited);
                }
            }
        }
        return numberofIsland;
    }

    private static void dfs(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int[] X = {0, -1, 0, 1};
        int[] Y = {1, 0, -1, 0};
        for (int k = 0; k < X.length; k++) {
            int ni = i + X[k];
            int nj = j + Y[k];
            boolean isCellValid = isValidCell(ni, nj, n, m, grid, visited);
            if(isCellValid){
                dfs(ni, nj, n, m, grid, visited);
            }
        }
    }

    private static boolean isValidCell(int ni, int nj, int n, int m, char[][] grid, boolean[][] visited) {
        if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || grid[ni][nj] == '0'){
            return  false;
        }
        return true;
    }
}
