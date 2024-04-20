package com.test.scaler.tct16;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        //List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<String> list = Arrays.asList("");

        ArrayList<ArrayList<String>> anagrams = getAnagrams(list);
        System.out.println(anagrams);
    }

    public static ArrayList<ArrayList<String>> getAnagrams(List<String> A) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            String str = A.get(i);
            if (set.contains(str)) {
                continue;
            }
            set.add(str);
            ArrayList<String> anagramList = new ArrayList<>();
            anagramList.add(str);
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            // explore all the strings in the array
            for (int j = i + 1; j < A.size(); j++) {
                String tempStr = A.get(j);
                if (set.contains(tempStr))
                    continue;

                if (str.length() != tempStr.length()) {
                    continue; // ignore this string and explore the other one
                }
                Map<Character, Integer> tempMap = new HashMap<>();
                for (char ch : tempStr.toCharArray()) {
                    tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
                }

                boolean isAnagram = true;
                for (char ch : map.keySet()) {
                    if (!tempMap.containsKey(ch) || map.get(ch) != tempMap.get(ch)) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    anagramList.add(tempStr);
                    set.add(tempStr);
                }
            }
            Collections.sort(anagramList);
            result.add(anagramList);
        }

        return result;
    }
}
