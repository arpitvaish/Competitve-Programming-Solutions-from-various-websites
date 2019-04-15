package com.sample.vault.demo;

import java.util.Scanner;

public class Solution {
	static int totalSwap = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		bubbleSort(a);
	}

	static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for (int j = 0; j < a.length - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					numberOfSwaps++;
				}
			}

			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				System.out.println("Array is sorted in " + totalSwap + " swaps.");
				System.out.println("First Element: " + a[0]);
				System.out.println("Last Element: " + a[a.length - 1]);
				break;
			} else {
				totalSwap += numberOfSwaps;
			}
		}
	}

	static void swap(int[] a, int b, int c) {
		int temp = 0;
		temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
}
