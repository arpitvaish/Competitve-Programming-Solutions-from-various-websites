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
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] xy = scanner.nextLine().split(" ");

            setX.add(Integer.parseInt(xy[0]));

            setY.add(Integer.parseInt(xy[1]));
        }

        if(setX.size() == 1 || setY.size() == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

        scanner.close();
    }
}
