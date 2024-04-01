package com.java.graph;

import java.util.*;

public class Dijkstra_V2 {

    public static void main(String[] args) {
        Dijkstra_V2 dijkstraV2 = new Dijkstra_V2();
        int n = 6;
        int[][] arr = {
                {0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}
        };

        int[] minDistance = dijkstraV2.solve(n, arr, 4);
        System.out.println(Arrays.toString(minDistance));
    }

    public int[] solve(int A, int[][] B, int C) {
        Map<Integer, List<Node>> adjList = constGraph(A, B);
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        int[] ans = new int[A];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[C] = 0;
        pq.add(new Node(C, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.verses;
            int u_distance = node.distance;
            for (Node nbrNode : adjList.get(u)) {
                int v = nbrNode.verses;
                int v_distance = nbrNode.distance;
                int v_newDistance = u_distance + v_distance;
                if (ans[v] > v_newDistance) {
                    ans[v] = v_newDistance;
                    pq.add(new Node(v, v_newDistance));
                }
            }
        }

        for (int i = 0; i < A; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private Map<Integer, List<Node>> constGraph(int n, int[][] edges) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        for (int node = 0; node < n; node++) {
            adjList.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }

        return adjList;
    }

    class Node {
        int verses;
        int distance;

        Node(int verses, int distance) {
            this.verses = verses;
            this.distance = distance;
        }
    }

}
