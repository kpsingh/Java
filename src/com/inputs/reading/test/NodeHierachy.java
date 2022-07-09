package com.inputs.reading.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://assessment.hackerearth.com/challenges/hiring/seclore-hiring-challenge-2/problems/
 */

public class NodeHierachy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int N = Integer.parseInt(name);

		Map<Integer, Node> map = new HashMap<>();

		for (int i = 0; i < N; i++) {

			/*
			 * 1. Get the input array 2. make the node 3. put into the map 4.
			 */

			int[] input = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			Set<Integer> set = new HashSet<>();

			for (int a : input) {
				set.add(a);
			}

			Node node = new Node(set);
			map.put(i, node);

		}

		//map.entrySet().forEach(System.out::println);

		// Now read the map for each object and

		for (int i = 0; i < map.entrySet().size(); i++) {

			Set<Integer> value_i = map.get(i).getValue();

			for (int j = i + 1; j < map.entrySet().size(); j++) {

				Set<Integer> value_j = map.get(j).getValue();

				if (value_i.containsAll(value_j)) {
					map.get(i).getChild().add(j);
				} else if (value_j.containsAll(value_i)) {
					map.get(j).getChild().add(i);
				}
			}

		}

		//System.out.println("**** After the parent-child ****");
		//map.entrySet().forEach(System.out::println);

		for (int i = 0; i < map.entrySet().size(); i++) {

			Set<Integer> child_i = map.get(i).getChild();
			ArrayList<Integer> list = new ArrayList<>();

			for (int a : child_i) {
				Set<Integer> child_j = map.get(a).getChild();
				for (int j : child_j) {
					if (child_i.contains(j)) {
						list.add(j);
					}
				}

			}
			for (int k : list) {
				child_i.remove(k);
			}

		}

		//System.out.println("**** After correcting the child ****");
		//map.entrySet().forEach(System.out::println);

		//System.out.println("**** Final Result ****");
		for (int i = 0; i < map.entrySet().size(); i++) {
			Set<Integer> child = map.get(i).getChild();

			if (child.size() == 0) {
				System.out.println(-1);
			} else {
				child.forEach(a -> System.out.print(a +" "));
				System.out.println();

			}

		}

	}

}

class Node {
	Node parent = null;
	Set<Integer> child = null;
	Set<Integer> value;

	Node(Set<Integer> value) {
		this.value = value;
		child = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Node [parent=" + parent + ", child=" + child + ", value=" + value + "]";
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Set<Integer> getChild() {
		return child;
	}

	public void setChild(Set<Integer> child) {
		this.child = child;
	}

	public Set<Integer> getValue() {
		return value;
	}

	public void setValue(Set<Integer> value) {
		this.value = value;
	}

}
