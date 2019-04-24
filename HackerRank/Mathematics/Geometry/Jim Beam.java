//https://www.hackerrank.com/challenges/jim-beam/problem

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the solve function below.
    static boolean solve(Point p1, Point p2, Point p3, Point p4) {

        Long o1 = direction(p1, p4, p2);
        Long o2 = direction(p1, p4, p3);
        Long o3 = direction(p2, p3, p1);
        Long o4 = direction(p2, p3, p4);

        if (((o1 > 0L && o2 < 0L) || (o1 < 0L && o2 > 0L)) && ((o3 > 0L && o4 < 0L) || (o3 < 0L && o4 > 0L)))
            return true;

        if (o1 == 0L && onSegment(p1, p4, p2))
            return true;
        if (o2 == 0L && onSegment(p1, p4, p3))
            return true;
        if (o3 == 0L && onSegment(p2, p3, p1))
            return true;
        if (o4 == 0L && onSegment(p2, p3, p4))
            return true;

        return false;


    }

    static Long direction(Point p1, Point p2, Point p3) {
        return (long) ((p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x));
    }

    public static boolean onSegment(Point p1, Point p2, Point p3) {
        boolean b1 = p3.x >= Math.min(p1.x, p2.x);
        boolean b2 = p3.x <= Math.max(p1.x, p2.x);
        boolean b3 = p3.y >= Math.min(p1.y, p2.y);
        boolean b4 = p3.y <= Math.max(p1.y, p2.y);
        if (b1 && b2 && b3 && b4)
            return true;

        return false;
    }

    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] x1Y1X2Y2XmYm = scanner.nextLine().split(" ");

            Point p1 = new Point(Integer.parseInt(x1Y1X2Y2XmYm[0]), Integer.parseInt(x1Y1X2Y2XmYm[1]));
            Point p2 = new Point(Integer.parseInt(x1Y1X2Y2XmYm[2]), Integer.parseInt(x1Y1X2Y2XmYm[3]));
            Point p3 = new Point(Integer.parseInt(x1Y1X2Y2XmYm[4]), Integer.parseInt(x1Y1X2Y2XmYm[5]));
            Point p0 = new Point(0, 0);


            boolean result = solve(p0, p1, p2, p3);

            System.out.println((result) ? "NO" : "YES");

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}

