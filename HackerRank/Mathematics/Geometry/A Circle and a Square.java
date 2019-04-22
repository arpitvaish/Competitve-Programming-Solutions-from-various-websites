//https://www.hackerrank.com/challenges/a-circle-and-a-square/problem
import java.util.Scanner;

public class Solution
{

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] wh = scanner.nextLine().split(" ");

        int w = Integer.parseInt(wh[0]);

        int h = Integer.parseInt(wh[1]);

        String[] circleXCircleY = scanner.nextLine().split(" ");

        int circleX = Integer.parseInt(circleXCircleY[1]);

        int circleY = Integer.parseInt(circleXCircleY[0]);

        int r = Integer.parseInt(circleXCircleY[2]);

        Circle circle = new Circle(new Point(circleX, circleY), r);

        String[] x1Y1X3Y3 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1Y1X3Y3[1]);

        int y1 = Integer.parseInt(x1Y1X3Y3[0]);

        int x3 = Integer.parseInt(x1Y1X3Y3[3]);

        int y3 = Integer.parseInt(x1Y1X3Y3[2]);

        Square square = Square.read(x1, y1, x3, y3);

        // Write Your Code Here
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (circle.contains(i, j) || square.contains(i, j)) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    static class Point {
        double x;
        double y;

        Point(double i, double j) {
            this.x = i;
            this.y = j;
        }
    }

    static class Circle {
        Point center;
        int r;

        public Circle(Point pt, int r) {
            this.center = pt;
            this.r = r;
        }

        boolean contains(int i, int j) {
            double di = i - center.x;
            double dj = j - center.y;
            return (di * di) + (dj * dj) <= r * r;
        }

    }

    static class Square {
        Point p1, p2, p3, p4;

        public Square(Point p1, Point p2, Point p3, Point p4) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }


        boolean contains(int i, int j) {
            return new Triangle(p1, p3, p2).contains(new Point(i, j)) || new Triangle(p1, p3, p4).contains(new Point(i, j));
        }

        static Square read(int x1, int y1, int x3, int y3) {

            //center points
            double cx = (x1 + x3) / 2.0;
            double cy = (y1 + y3) / 2.0;

            //vector from center to x1, y1
            double dx = x1 - cx;
            double dy = y1 - cy;

            //vecors perpendicular
            double px = -1 * dy;
            double py = dx;

            double x2 = cx + px;
            double y2 = cy + py;

            double x4 = cx - px;
            double y4 = cy - py;

            return new Square(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));
        }
    }

    static class Triangle {
        Point p1, p2, p3;
        double area;

        public Triangle(Point p1, Point p2, Point p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.area = Math.abs(((p3.x - p1.x) * (p2.y - p1.y)) - ((p3.y - p1.y) * (p2.x - p1.x))) / 2;
        }


        boolean contains(Point p) {
            return this.area == new Triangle(p1, p2, p).area + new Triangle(p2, p3, p).area + new Triangle(p3, p1, p).area;
        }
    }

}
