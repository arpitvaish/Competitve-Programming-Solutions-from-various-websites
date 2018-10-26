import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        double positiveCount = 0, negativeCount = 0, zeroCount=0;
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            if(arrItem>0)
                positiveCount++;
            else if(arrItem<0)
                negativeCount++;
            else
                zeroCount++;
        }
        
        NumberFormat f = new DecimalFormat("#0.000000");
        System.out.println(f.format(positiveCount/n));
        System.out.println(f.format(negativeCount/n));
        System.out.println(f.format(zeroCount/n));

        scanner.close();
    }
}
