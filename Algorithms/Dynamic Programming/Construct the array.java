//https://www.hackerrank.com/challenges/construct-the-array/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long countArray(int n, int k, int x) {
        long dp[][] = new long[n][2];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = ((k - 1) * dp[i - 1][1]) % 1000000007;
            dp[i][1] = ((dp[i - 1][0] + ((k - 1) * dp[i - 1][1])) - dp[i - 1][1]) % 1000000007;

        }
       return x == 1 ? dp[n - 1][0] : dp[n - 1][1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkx = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkx[0]);

        int k = Integer.parseInt(nkx[1]);

        int x = Integer.parseInt(nkx[2]);

        long answer = countArray(n, k, x);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
