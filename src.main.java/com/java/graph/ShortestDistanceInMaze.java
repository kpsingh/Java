package com.java.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right,
but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops,
it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty
spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot
stop at the destination, return -1.
 */
public class ShortestDistanceInMaze {

    private static final int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

    }

    public static int bfs(int[][] A, int[] B, int[] C) {

        int n = A.length, m = A[0].length;

        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);  // Initialize all distances as infinite
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{B[0], B[1], 0}); // {row, col, distance}
        distance[B[0]][B[1]] = 0;  // Distance from start to itself is 0

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            // If we reach the destination, return the shortest distance
            if (x == C[0] && y == C[1]) {
                return dist;
            }

            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = x, ny = y, steps = 0;

                // Roll the ball in the current direction until hitting a wall
                while (nx + dx[d] >= 0 && nx + dx[d] < n && ny + dy[d] >= 0 && ny + dy[d] < m && A[nx + dx[d]][ny + dy[d]] == 0) {
                    nx += dx[d];
                    ny += dy[d];
                    steps++;
                }

                // If found a shorter path, update and push to queue
                if (distance[nx][ny] > dist + steps) {
                    distance[nx][ny] = dist + steps;
                    queue.add(new int[]{nx, ny, dist + steps});
                }
            }
        }

        return -1; // Destination not reachable
    }


}
