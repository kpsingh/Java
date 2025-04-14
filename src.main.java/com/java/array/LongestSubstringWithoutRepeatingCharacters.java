package com.java.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxlength = 0;
        for(int left = 0, right = 0; right < s.length(); right++){
            char key = s.charAt(right);
            map.put(key, map.getOrDefault(key, 0) + 1);
            while (map.get(key) > 1){
                char remKey = s.charAt(left++);
                map.put(remKey, map.get(remKey) - 1);
            }
            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
    }
}
