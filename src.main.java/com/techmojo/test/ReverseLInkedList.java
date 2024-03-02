package com.techmojo.test;import javax.swing.event.TableColumnModelListener;

public class ReverseLInkedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		System.out.println("Before Reversal");
		
		ListNode temp = head;
		while(temp!= null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		temp = reverseLinkedList(head);
		
		System.out.println("\nAfter Reversal");
		while(temp!= null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		
		
	}

	public static ListNode reverseLinkedList(ListNode head) {

		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			ListNode next = curr.next; // have the reference of future next node
			curr.next = prev; // change the direction / reverse
			prev = curr; // swap the curr as prev
			curr = next; // move the curr to next
		}

		head = prev; // changing the head to prev

		return head;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}