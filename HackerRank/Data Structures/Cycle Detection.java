import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}

		public String toString() {
			return "" + data;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	static boolean hasCycle(SinglyLinkedListNode head) {

		if (head == null || head.next == null) {
			return false;
		}

		SinglyLinkedListNode tortoise = head;
		SinglyLinkedListNode hare = head.next.next;
		while (null != hare && null != hare.next) {
			if (hare == tortoise) {
				return true;
			}
			tortoise = tortoise.next;
			hare = hare.next.next;
		}

		return false;

	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

		if (head == null)
			return null;
		SinglyLinkedListNode nextItem = head.next;
		while (nextItem != null && head.data == nextItem.data) {
			nextItem = nextItem.next;
		}
		head.next = removeDuplicates(nextItem);
		return head;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
			SinglyLinkedListNode temp = llist.head;

			for (int i = 0; i < llistCount; i++) {
				if (i == index) {
					extra = temp;
				}

				if (i != llistCount - 1) {
					temp = temp.next;
				}
			}

			temp.next = extra;

			boolean result = hasCycle(llist.head);

			// printSinglyLinkedList(llist1, " ", bufferedWriter);

			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
