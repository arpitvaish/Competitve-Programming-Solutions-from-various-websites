package com.sample.vault.demo;

import java.io.IOException;
import java.util.Scanner;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class Solution {

	public static Node insert(Node head, int data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
			return head;
		} 
		else{
			head.next = insert(head.next,data);
		}
		

		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}
