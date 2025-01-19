package com.java.leetcode.january;

/*
https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
1368. Minimum Cost to Make at Least One Valid Path in a Grid
 */

import java.util.*;

public class LC_Jan18 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {2, 2, 2, 2}
        };
        System.out.println(minCost(grid));
    }

    public static int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Directions: right, left, down, up
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Priority queue for 0-1 BFS
        Deque<Pair> deque = new ArrayDeque<>();
        deque.offer(new Pair(0, 0, 0)); // {x, y, cost}

        // Visited array
        int[][] visited = new int[n][m];
        for (int[] row : visited){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        visited[0][0] = 0;

        while (!deque.isEmpty()) {
            Pair pair = deque.pollFirst();
            int x = pair.x, y = pair.y, cost = pair.cost;

            if (x == n - 1 && y == m - 1)
                return cost;

            for (int d = 0; d < 4; d++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                int newCost = cost + (d + 1 == grid[x][y] ? 0 : 1);

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && newCost < visited[nx][ny]) {
                    visited[nx][ny] = newCost;

                    if (newCost == cost) {
                        deque.offerFirst(new Pair(nx, ny, newCost)); // Zero-cost move
                    } else {
                        deque.offerLast(new Pair(nx, ny, newCost)); // Costly move
                    }
                }
            }
        }

        return -1; // Unreachable (should not happen for valid inputs)
    }
}

