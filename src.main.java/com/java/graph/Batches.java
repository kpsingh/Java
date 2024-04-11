package com.java.graph;

import java.util.*;

public class Batches {
    public static void main(String[] args) {

    }

    public int solve(int A, int[] B, int[][] C, int D) {
        Map<Integer, List<Integer>> adjList = constructGraph(A, C);
        Set<Integer> visited = new HashSet<>();
        int numberOfBatchSelected = 0;
        for (int node = 1; node <= A; node++) {
            if (!visited.contains(node)) {
                int batchStrength = bfs(node, B, visited, adjList);
                if (batchStrength >= D) {
                    numberOfBatchSelected++;
                }
            }
        }
        return numberOfBatchSelected;
    }

    private int bfs(int src, int[] B, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        int batchStrength = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            batchStrength += B[node - 1];
            for (int nbr : adjList.get(node)) {
                if (!visited.contains(nbr)) {
                    q.add(nbr);
                }
            }
        }
        return batchStrength;
    }

    private Map<Integer, List<Integer>> constructGraph(int A, int[][] C) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int node = 1; node <= A; node++) {
            adjList.put(node, new ArrayList<>());
        }
        for (int[] edge : C) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
