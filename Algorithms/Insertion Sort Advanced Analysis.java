//First of all I solved this using Insertion Sort. But it passed only 7 test cases and other resulted in Time out.
//As insertion sort takes O(n^2) time, hence not able to pass all tests. So to be able to pass all test cases we need to use
//merge sort and then count the number of inversions.
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the insertionSort function below.
	static long merge(Integer[] arr, int p, int mid, int q) {
		// Consumer<String> c1 = x -> System.out.println(x);

		int n1 = mid - p + 1;
		int n2 = q - mid;
		long count = 0;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		for (int i = 0; i < n1; i++)
			L[i] = arr[p + i];

		for (int i = 0; i < n2; i++)
			R[i] = arr[mid + i + 1];

		int i = 0, j = 0;

		for (int k = p; k < (p + n1 + n2); k++) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				if (L[i] != Integer.MAX_VALUE) {
					count += n1 - i;
				}
				j++;

			}
		}

		return count;
	}

	static long mergeSort(Integer[] arr, int p, int q) {
		long ans = 0;
		if (p < q) {
			int mid = (p + q) / 2;
			ans += mergeSort(arr, p, mid);
			ans += mergeSort(arr, mid + 1, q);
			ans += merge(arr, p, mid, q);
		}
		return ans;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			Integer[] arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				int arrItem = scanner.nextInt();
				arr[i] = arrItem;

			}
			long result = mergeSort(arr, 0, arr.length - 1);
			System.out.println(result);
		}

		scanner.close();
	}
}
