import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
	public difference(int[] elements){
        this.elements = elements;
    }
    
    public int computeDifference(){
        int i=0,j=1, diff= 0;
        while(i<j){
            j=i+1;
            while(j<this.elements.length){
                diff = Math.abs(this.elements[i]-this.elements[j]);
                j++;
                if(this.maximumDifference < diff){
                    this.maximumDifference = diff;
                }
            }
            i++;
        }
        return this.maximumDifference;
    }
} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
