package com.java.practice.map;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap {
    LinkedList<MyEntry>[] buckets;
    int capacity;
    int size;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<MyEntry>();
        }
        this.size = 0;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        int keyIndex = findIndexOfKeyInLinkedList(hash, key);
        if (keyIndex == -1) {
            // element is not there in the bucket, put that

            if (buckets[hash].size() == 0)
                size++;
            buckets[hash].add(new MyEntry(key, value, hash));

        } else {
            // element already exist just update the with new value
            buckets[hash].get(keyIndex).val = value;
        }

    }

    private int findIndexOfKeyInLinkedList(int hash, int key) {
        LinkedList<MyEntry> list = buckets[hash];
        // if the given key exist then it must exist in this list because for given key the hash function point to this  bucket
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return i; // element exist at ith position
            }
        }
        return -1; // element not exist in the
    }

    public int get(int key) {
        int hash = getHash(key);
        int keyIndex = findIndexOfKeyInLinkedList(hash, key);
        if (keyIndex == -1) {
            return -1; // this element not exist
        } else {
            // element already exist just update the with new value
            return buckets[hash].get(keyIndex).val;
        }
    }

    public void remove(int key) {
        int hash = getHash(key);
        int keyIndex = findIndexOfKeyInLinkedList(hash, key);
        if (keyIndex != -1) {
            buckets[hash].remove(keyIndex);
            if (buckets[hash].size() == 0)
                size--;
        }

    }

    public int size() {
        return size;
    }

    private int getHash(int key) {
        int hash = Math.abs((Integer) key) % capacity;
        return hash;
    }


    @Override
    public String toString() {
        return "MyHashMap{" + "arr=" + Arrays.toString(buckets) + ", capacity=" + capacity + ", size=" + size + '}';
    }

    class MyEntry {
        int key;
        int val;
        int hash;

        public MyEntry(int key, int val, int hash) {
            this.key = key;
            this.val = val;
            this.hash = hash;
        }

        @Override
        public String toString() {
            return "MyEntry{" + "key=" + key + ", val=" + val + ", hash=" + hash + '}';
        }
    }
}
