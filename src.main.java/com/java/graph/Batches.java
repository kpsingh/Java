package com.java.graph;

import java.util.*;

/*
A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 */
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
