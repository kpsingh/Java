package com.java.leetcode.february;

/*
https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

1790. Check if One String Swap Can Make Strings Equal


Step 1: If s1 and s2 are already equal, return true.
✔ Step 2: Find the indices where the characters differ.
✔ Step 3: If more than two mismatches, return false (as we can swap only once).
✔ Step 4: If exactly two differences, check if swapping them makes the strings equal.



 */
public class LC_feb05 {
    public static void main(String[] args) {

        String s1 = "bank";
        String s2 = "kanb";
        boolean result = areAlmostEqual(s1, s2);
        System.out.println(result);

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // If already equal, return true

        int first = -1, second = -1;

        // Find positions where characters differ
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false; // More than two differences → return false
                }
            }
        }

        // Check if exactly two characters can be swapped
        return (second != -1 &&
                s1.charAt(first) == s2.charAt(second) &&
                s1.charAt(second) == s2.charAt(first));
    }
}
