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
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            int i=1,j=i+1,result=0,max=0;
            while(i<n){
                j=i+1;
                while(j<=n){
                    result = i & j;
                    if(result > max && result < k){

                            max = result;
                    }
                    j++;
                }
                
                i++;
            }
            System.out.println(max);
           
        }

        scanner.close();
    }
}
