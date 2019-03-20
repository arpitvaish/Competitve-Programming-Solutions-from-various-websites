//https://www.hackerrank.com/challenges/countingsort2/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] newArray = new int[100];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            newArray[value] += 1;
        }

        for (int i = 0; i < 100; i++) {
            int val = newArray[i];
            if (val == 0) {
                continue;
            } else {
                while (val-- > 0) {
                    list.add(i);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
