package com.java.graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 4}, {2, 4}, {2, 3}, {3, 5}, {5, 6}, {4, 5}};
        int source = 1;
        int target = 6;

        // construct the graph
        Map<Integer, ArrayList<Integer>> graph = constructGraph(edges);
        boolean isReachable = bfs(graph, source, target);
        System.out.println("Target " + target + " is reachable from source " + source + " : " + isReachable);

    }

    /*
     from the given source, find if destination can traversed.
     */
    public static boolean bfs(Map<Integer, ArrayList<Integer>> graph, int source, int destination) {
        boolean[] visited = new boolean[graph.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            // System.out.print(current + " ");
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return visited[destination];
    }

    /*
    there is nodes between 1 - n
     */

    private static Map<Integer, ArrayList<Integer>> constructGraph(int[][] edges) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
