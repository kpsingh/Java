package com.java.practice.map;

import java.util.*;

public class ConsistentHashing2 {

    private final TreeMap<Integer, String> circle = new TreeMap<>();
    private final int numberOfReplicas;

    public ConsistentHashing2(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    // Add a node to the hash ring
    public void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = (node + i).hashCode();
            circle.put(hash, node);
        }
    }

    // Remove a node from the hash ring
    public void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = (node + i).hashCode();
            circle.remove(hash);
        }
    }

    // Get the node to which the given key is mapped
    public String getNodeForKey(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = key.hashCode();
        Map.Entry<Integer, String> entry = circle.ceilingEntry(hash);
        if (entry == null) {
            // If the key hash is greater than the last entry's hash, wrap around
            entry = circle.firstEntry();
        }
        return entry.getValue();
    }

    public static void main(String[] args) {
        // Create a consistent hash ring with 3 replicas
        ConsistentHashing2 hashRing = new ConsistentHashing2(3);

        // Add nodes to the hash ring
        hashRing.addNode("Node-1");
        hashRing.addNode("Node-2");
        hashRing.addNode("Node-3");

        // Get the node to which a key is mapped
        String key = "example_key";
        String node = hashRing.getNodeForKey(key);
        System.out.println("Key '" + key + "' is mapped to node: " + node);
    }
}
