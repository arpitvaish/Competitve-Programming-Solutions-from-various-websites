import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int actualD = sc.nextInt();
        int actualM = sc.nextInt();
        int actualY = sc.nextInt();
        int returnD = sc.nextInt();
        int returnM = sc.nextInt();
        int returnY = sc.nextInt();
        int yearDiff = actualY- returnY;
        int monthDiff = actualM - returnM;
        int dayDiff = actualD-returnD;
        
        int fine = (actualY>returnY)?10000:(actualM>returnM && yearDiff == 0)?500*monthDiff: (actualD > returnD && monthDiff == 0)?15*(actualD-returnD):0;
        
        System.out.println(fine);
        
    }
}
