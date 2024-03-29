package com.java.graph;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        int n = 10; // nodes from 1 - n

        int[][] arr = {{1, 2, 4}, {1, 4, 8}, {1, 7, 2}, {2, 3, 5}, {2, 7, 1}, {2, 8, 9}, {3, 8, 1}, {3, 10, 1}, {4, 7, 3},
                {5, 8, 6}, {6, 8, 3},
                {6, 9, 2},
                {7, 8, 4},
                {9, 10, 4}
        };

        int[] minDistance = findMinDistance(1, n, arr);
        System.out.println(Arrays.toString(minDistance));
    }

    private static int[] findMinDistance(int src, int n, int[][] arr) {
        Map<Integer, List<Vertex>> adjList = populateGraph(n, arr);
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0; // assuming this is the source node
        Queue<Vertex> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.add(new Vertex(src, 0));

        while (!pq.isEmpty()) {
            Vertex currNode = pq.poll();
            int currVertexDistance = currNode.distance;
            for (Vertex nbrNode : adjList.get(currNode.value)) {
                int nbrDistance = currVertexDistance + getDistance(currNode, nbrNode, adjList);
                if (dis[nbrNode.value] > nbrDistance) {
                    dis[nbrNode.value] = nbrDistance;
                    pq.offer(new Vertex(nbrNode.value, nbrDistance));
                }

            }
        }
        return dis;
    }

    private static int getDistance(Vertex u, Vertex v, Map<Integer, List<Vertex>> adjList) {
        for (Vertex nbr : adjList.get(u.value)) {
            if (nbr.value == v.value) {
                return nbr.distance;
            }
        }
        return 0;
    }

    private static Map<Integer, List<Vertex>> populateGraph(int n, int[][] edges) {
        Map<Integer, List<Vertex>> adjList = new HashMap<>();
        for (int node = 1; node <= n; node++) {
            adjList.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Vertex(v, w));
            adjList.get(v).add(new Vertex(u, w));
        }

        return adjList;
    }
}

class Vertex {
    int value;
    int distance;

    Vertex(int v, int w) {
        this.value = v;
        this.distance = w;
    }
}
