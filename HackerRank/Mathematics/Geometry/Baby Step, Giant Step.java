//https://www.hackerrank.com/challenges/baby-step-giant-step/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(int a, int b, int d) {

        if(d >= b){
            return (d+b-1)/b;
        }
        if(d == 0){
            return 0;
        }
        if(d == a){
            return 1;
        }
        return 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] abd = scanner.nextLine().split(" ");

            int a = Integer.parseInt(abd[0]);

            int b = Integer.parseInt(abd[1]);

            int d = Integer.parseInt(abd[2]);

            int result = solve(a, b, d);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
