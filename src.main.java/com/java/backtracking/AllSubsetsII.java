package com.java.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class AllSubsetsII {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(3);



        AllSubsetsII subsetsII = new AllSubsetsII();
        subsetsII.subsetsWithDup(list);
        System.out.println(subsetsII.ans);
        System.out.println("Size : " + subsetsII.ans.size());


    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        int index = 0;
        subsetsWithDup(A, index, new ArrayList<Integer>());
        Collections.sort(ans, (l1, l2) -> {
            for(int i = 0; i < Math.min(l1.size(), l2.size()); i++){
                if (l1.get(i) != l2.get(i)){
                    return l1.get(i) - l2.get(i);
                }
            }

            return l1.size() - l2.size();
        });

        return ans;
    }

    private void subsetsWithDup(ArrayList<Integer> A, int index, ArrayList<Integer> list) {
        if (index == A.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(A.get(index));

        while (index + 1 < A.size() && A.get(index) == A.get(index + 1)){
            index++;
        }

        subsetsWithDup(A, index + 1, list);
        list.remove(list.size() - 1);
        subsetsWithDup(A, index + 1, list);
    }
}
