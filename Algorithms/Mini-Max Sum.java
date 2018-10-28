import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static void miniMaxSum(int[] arr) {
        
       long min = Long.MAX_VALUE, max = Long.MIN_VALUE,    sum = 0;
        int j = 0;
        while (j < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (i == j) {
                    continue;
                }
                sum += arr[i];

            }
            if (sum<min)
                min = sum;
            if (sum>max)
                max = sum;

            sum = 0;
            j++;
        }
        System.out.println(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
