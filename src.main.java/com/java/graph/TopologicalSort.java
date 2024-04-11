package com.java.graph;

import java.util.*;


public class TopologicalSort {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] inDegree = new int[A + 1];
        Map<Integer, List<Integer>> adjList = constructGraph(A, inDegree, B);

        // check for cycle
        boolean isCycle = false;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int node = 1; node <= A; node++) {
            if (!visited.contains(node)) {
                visited.add(node);
                isCycle = dfs(node, adjList, visited, path);
                if (isCycle)
                    break;
                ;
            }
        }

        if (isCycle) {
            return new ArrayList<>();
        }

        // Find the Path

        Queue<Integer> q = new LinkedList<>();
        for (int node = 1; node <= A; node++) {
            if (inDegree[node] == 1) {
                q.add(node);
            }
        }

        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalOrder.add(node);
            for (int nbr : adjList.get(node)) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        return topologicalOrder;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> path) {
        path.add(node);
        for (int nbr : adjList.get(node)) {
            if (path.contains(nbr)) {
                return false;
            }
            if (!visited.contains(nbr)) {
                visited.add(nbr);
                if (dfs(nbr, adjList, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(node);
        return false;
    }


    private Map<Integer, List<Integer>> constructGraph(int A, int[] inDegree, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int node = 1; node <= A; node++) {
            adjList.put(node, new ArrayList<>());
        }

        for (List<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            inDegree[v]++;
        }
        return adjList;
    }
}
