package com.java.practice.map;

public class MyHashMapClient {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(3);

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println(map);

        map.put(4, 40);

        System.out.println(map);

        map.remove(1);
        System.out.println(map);

        map.remove(2);
        System.out.println(map);

        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(1));

    }
}
