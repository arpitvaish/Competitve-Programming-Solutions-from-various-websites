// https://www.hackerrank.com/challenges/countingsort4/problem

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sol {

	// Complete the countSort function below.
	static void countSort(List<List<String>> arr) {

		int[] order = new int[arr.size()];
		String[] converted = new String[arr.size()];
		int[] count = new int[arr.size()];
		int mid = arr.size() / 2;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			List<String> str = arr.get(i);
			order[i] = Integer.parseInt(str.get(0));
			count[order[i]]++;
			if (i < mid) {
				converted[i] = "-";
			} else {
				converted[i] = str.get(1);
			}

		}

		for (int j = 0; j < count.length; j++) {
			if (count[j] > 0) {
				int i = 0;
				while (count[j] > 0 && i < order.length) {
					if (order[i] == j) {
						result.append(converted[i] + " ");
						count[j]--;
					}
					i++;
				}
			}
		}

		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		countSort(arr);

		bufferedReader.close();
	}
}
