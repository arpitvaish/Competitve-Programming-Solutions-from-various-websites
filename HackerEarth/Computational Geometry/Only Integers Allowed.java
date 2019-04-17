
//https://www.hackerearth.com/problem/algorithm/integers-only-allowed/description/

import java.util.Scanner;


public class Solutions {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        x[n] = x[0];
        y[n] = y[0];

        //Area of a polygon = 1/2 summation(0 - n-1)(X(i)* y(i+1) - X(i+1) + Y(i)
        double area = 0.0;
        for (int i = 0; i < n; i++) {
            area += (x[i + 1] * y[i]) - (x[i] * y[i + 1]);
        }

        //To find number of points with integer coordinates on border you may add
        // this value over all sides of polygon; it is quite well-known that for
        // line segment this values is equal to gcd(dx,dy) (+1 - in case if we are taking both endpoints).
        int borderPoints = 0;
        for (int i = 0; i < n; i++) {
            borderPoints += gcd(y[i + 1] - y[i], x[i + 1] - x[i]);
            //borderPoints +=1;
        }
        //borderPoints += n;


        //By Pick's Theorem : A=i+{b/2}-1.
        double innerPoints = (area + 2 - borderPoints) / 2;
        System.out.println((int) (area - borderPoints + 2) / 2);

    }

    public static int gcd(int a, int b) {
        int points = 0;
        if (b == 0) {
            return a;
        }
        a = Math.abs(a);
        b = Math.abs(b);

        return gcd(b, a % b);
    }

}
