import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the getWays function below.
	static long getWays(int n, long[] c) {
		Arrays.sort(c);
		long dp[][] = new long[c.length + 1][n + 1];

		for (int i = 0; i < c.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= c.length; i++) {
			for (int j = 1; j <= n; j++) {

				if (j == 0) {
					dp[i][j] = 1;
				}

				if (c[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][(int) (j - c[i - 1])];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[c.length][n];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		long[] c = new long[m];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			long cItem = Long.parseLong(cItems[i]);
			c[i] = cItem;
		}

		// Print the number of ways of making change for 'n' units using coins
		// having the values given by 'c'

		long ways = getWays(n, c);
		System.out.println(ways);
		// bufferedWriter.append(Long.toString(ways));
		// bufferedWriter.close();

		scanner.close();
	}
}
