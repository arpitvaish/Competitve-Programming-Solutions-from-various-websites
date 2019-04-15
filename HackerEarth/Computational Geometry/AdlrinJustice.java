//https://hackbenchers.hackerearth.com/ja/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/aldrin-justice/
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AdlrinJustice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] x = new int[4];
		while (n-- > 0) {
			x[0] = scanner.nextInt();
			x[1] = scanner.nextInt();
			x[2] = scanner.nextInt();
			x[3] = scanner.nextInt();
			System.out.println(getTimeLine(x));
		}
	}

	public static String getTimeLine(int[] x) {

		String s = null;

		int len1 = Math.abs(x[0] - x[1]) + 1;
		int len2 = Math.abs(x[2] - x[3]) + 1;
		int arr1[] = new int[len1];
		int arr2[] = new int[len2];

		int start;
		if (x[0] < x[1]) {
			start = x[0];
		} else {
			start = x[1];
		}

		for (int i = 0; i < len1; i++) {
			arr1[i] = start + i;
		}

		int start1;
		if (x[2] < x[3]) {
			start1 = x[2];
		} else {
			start1 = x[3];
		}
		for (int j = 0; j < len2; j++) {
			arr2[j] = start1 + j;
		}

		int count = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (arr1[i] == arr2[j]) {
					count++;
				}
			}
		}

		if (count > 0) {
			if (count == 1) {
				s = "Point";
			} else {
				s = "Nothing";
			}
		} else {
			s = "Line";
		}

		return s;
	}
}
