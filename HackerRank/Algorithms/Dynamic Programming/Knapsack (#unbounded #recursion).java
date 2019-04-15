/*
https://www.hackerrank.com/challenges/unbounded-knapsack/problem

input
2
3 12
1 6 9
5 9
3 4 4 4 8

output
12
9


input
2
4 13
3 7 9 11
3 11
3 7 9

output
13
10

*/
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int unboundedKnapsack(int k, int[] arr, int[] dp) {

		if (k == 0) {
			return 0;
		}

		if (dp[k] != -1) {
			return dp[k];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				max = Math.max(Math.max(max, unboundedKnapsack(k - 1, arr, dp)),
						arr[i] + unboundedKnapsack(k - arr[i], arr, dp));

			} else {
				max = Math.max(max, unboundedKnapsack(k - 1, arr, dp));
			}

		}

		dp[k] = max;
		return dp[k];

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		while (t-- > 0) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int dp[] = new int[k + 1];
			Arrays.sort(arr);
			Arrays.fill(dp, -1);
			dp[0] = 0;
			/*
			 * for (int i = 0; i < arr[0]; i++) { dp[i] = 0; }
			 */
			int result = unboundedKnapsack(k, arr, dp);

			System.out.println(result);
		}
	}
}
