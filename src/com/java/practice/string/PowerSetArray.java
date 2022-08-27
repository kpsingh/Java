package com.java.practice.string;

import java.util.ArrayList;
import java.util.List;

public class PowerSetArray {

	public static void main(String[] args) {

		int[] num = { 1, 2, 3 };

		List<List<Integer>> list = subsets(num);
		for (List<Integer> l : list) {
			System.out.println(l);
		}

	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> superSet = new ArrayList<>();

		List<Integer> set = new ArrayList<Integer>();

		subsetsHelper(superSet, set, nums, 0);

		return superSet;

	}

	private static void subsetsHelper(List<List<Integer>> superSet, List<Integer> result, int[] nums, int start) {

		superSet.add(new ArrayList<>(result));

		for (int i = start; i < nums.length; i++) {
			// add element
			result.add(nums[i]);
			// Explore
			subsetsHelper(superSet, result, nums, i + 1);
			// remove
			result.remove(result.size() - 1);
		}
	}

}
