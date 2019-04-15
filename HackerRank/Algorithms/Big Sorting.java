import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class FastReaderIO {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

class stringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {

		if (s1.length() == s2.length()) {
			return s1.compareTo(s2);
		}
		return s1.length() - s2.length();
	}
}

class mergeSort {
	public void mergeS(String arr[], int beg, int end) {

		if (beg < end) {
			int mid = (beg + end) / 2;
			mergeS(arr, beg, mid);
			mergeS(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
	}

	public void merge(String arr[], int beg, int mid, int end) {
		int n1 = mid - beg + 1;
		int n2 = end - mid;

		String[] L = new String[n1];
		String[] R = new String[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[beg + i];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + i + 1];
		}

		int i = 0, j = 0, k = beg;
		stringComparator st = new stringComparator();
		while (i < n1 && j < n2) {
			if (st.compare(L[i], R[j]) < 0) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < L.length) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < R.length) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}

public class Solution {

	static FastReaderIO.FastReader fr = new FastReaderIO.FastReader();

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = fr.nextInt();

		String[] unsorted = new String[n];

		for (int i = 0; i < n; i++) {
			String unsortedItem = fr.nextLine();
			unsorted[i] = unsortedItem;
		}

		mergeSort ms = new mergeSort();
		ms.mergeS(unsorted, 0, unsorted.length - 1);
		// Arrays.sort(unsorted, new stringComparator());

		/*
		 * for (int i = 0; i < result.length; i++) {
		 * bufferedWriter.write(result[i]);
		 * 
		 * if (i != result.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
		List<String> ls = Arrays.asList(unsorted);
		ls.forEach(System.out::println);

	}
}
