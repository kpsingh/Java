package com.java.backtracking;

import java.util.*;

public class AllPermutationsUnique {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 9, 10, 9, 10);
        Collections.sort(list);// 10,9,10,9,10
        AllPermutationsUnique per = new AllPermutationsUnique();
        per.permute(list);
        System.out.println(per.ans);
        System.out.println(per.ans.size());
    }

    public ArrayList<ArrayList<Integer>> permute(List<Integer> A) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int index = 0;
        permute(A, index, map, new ArrayList<Integer>());
        return ans;

    }

    private void permute(List<Integer> A, int index, HashMap<Integer, Integer> map, ArrayList<Integer> list) {
        if (index == A.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            if ((i < A.size() - 1) && a == A.get(i + 1)) {
                continue;
            }
            if (map.get(a) > 0) {
                list.add(a);
                map.put(a, map.get(a) - 1);
                permute(A, index + 1, map, list);

                list.remove(list.size() - 1);
                map.put(a, map.get(a) + 1);

            }
        }

    }
}
