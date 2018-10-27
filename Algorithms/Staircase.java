import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void staircase(int n) {
        int k = 0;
        while (k < n) {

            if (n - k - 1 > 0)
                System.out.printf("%" + (n - k - 1) + "s", "");

            for (int i = 0; i <= k; i++) {
                System.out.print("#");
            }

            System.out.println();
            k++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
