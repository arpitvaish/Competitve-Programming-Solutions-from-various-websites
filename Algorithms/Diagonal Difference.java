import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];
        int primaryDiagnolSum = 0;
        int secondaryDiagnolSum = 0;
        int diagnolDifference = 0;
        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < n; j++) {
                if(j==n-i-1){
                    primaryDiagnolSum += Integer.parseInt(arrRowItems[j]);
                }
                if(j==i){
                    secondaryDiagnolSum += Integer.parseInt(arrRowItems[j]);
                }
            }
        }

        int result = Math.abs(primaryDiagnolSum-secondaryDiagnolSum);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
