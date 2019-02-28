/*
Problem: https://www.hackerrank.com/challenges/sherlock-and-cost/problem
*/

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int cost(int[] arr, int n) {

		int dp[][] = new int[n][2];
		for (int i = 0; i < n - 1; ++i) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(1 - arr[i]));
			dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(1 - arr[i + 1]), dp[i][1] + Math.abs(arr[i + 1] - arr[i]));
		}
		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] B = new int[n];

			String[] BItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int BItem = Integer.parseInt(BItems[i]);
				B[i] = BItem;
			}

			int result = cost(B, n);

			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
