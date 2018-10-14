import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = 0;boolean prime = true;
        int count =  sc.nextInt();
        for(int i=1;i<=count;i++){
            num = sc.nextInt();
            prime = true;
            if(num == 1){
               System.out.println("Not prime");
                continue;
            }
            for(int j=2;j<=Math.sqrt(num);j++){
                if(num%j == 0){
                    prime = false;
                    System.out.println("Not prime");
                    break;
                }
            }
            if(prime)
            System.out.println("Prime");
        }
    }
}

