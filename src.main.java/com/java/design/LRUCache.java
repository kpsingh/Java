package com.java.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // Node class for the doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Cache properties
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // Most recently used
    private final Node tail; // Least recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        // Initialize dummy head and tail nodes
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Return -1 if key doesn't exist
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Retrieve node and move to front (most recently used)
        Node node = cache.get(key);
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        // Update existing node
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        // Remove least recently used item if at capacity
        if (cache.size() >= capacity) {
            Node leastUsed = tail.prev;
            removeNode(leastUsed);
            cache.remove(leastUsed.key);
        }

        // Add new node
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
    }

    // Helper method to add node right after head (as most recently used)
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Helper method to remove a node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to move node to head (most recently used position)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}