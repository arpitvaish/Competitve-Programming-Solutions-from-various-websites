/*
https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
input:
5 6
1 2 3 4 1
3 4 1 2 1 3

output:
3 4 1

input:
9 10
3 9 8 3 9 7 9 7 0
3 3 9 9 9 1 7 2 0 6

output:
3 3 9 9 7 0



*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the longestCommonSubsequence function below.
	static Integer[] longestCommonSubsequence(int[] a, int[] b) {

		int c[][] = new int[a.length + 1][b.length + 1];
		int d[][] = new int[a.length + 1][b.length + 1];
		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					d[i][j] = 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					d[i][j] = 2;
				} else {
					c[i][j] = c[i][j - 1];
					d[i][j] = 3;
				}
			}
		}

		List<Integer> list = printLCS(c, d, a, b);
		Collections.reverse(list);
		System.out.println(list);
		return list.toArray(new Integer[list.size()]);

	}

	static List<Integer> printLCS(int[][] c, int[][] b, int[] X, int[] Y) {
		List<Integer> ans = new ArrayList<>();
		for (int i = c.length-1; i >= 0; i--) {
			for (int j = c[0].length-1; j >= 0; j--) {
				if(b[i][j] == 1){
					ans.add(X[i-1]);
					i--;
				}
				else if(b[i][j] == 2){
					i--;
					j++;
				}
				else{
					
					
				}
			}
		}

		return ans;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b[i] = bItem;
		}

		Integer[] result = longestCommonSubsequence(a, b);

		/*
		 * for (int i = 0; i < result.length; i++) {
		 * bufferedWriter.write(String.valueOf(result[i]));
		 * 
		 * if (i != result.length - 1) { bufferedWriter.write(" "); } }
		 */

		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
