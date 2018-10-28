import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	// Complete the dynamicArray function below.
	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		List<List<Integer>> seqList = new ArrayList<>(n);
		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < n; j++)
			seqList.add(new ArrayList<Integer>());
		int lastAnswer = 0, seq = 0;
		for (int i = 0; i < queries.size(); i++) {
			seq = (queries.get(i).get(1) ^ lastAnswer) % n;
			int value = queries.get(i).get(2);
			if (queries.get(i).get(0) == 1) {
				seqList.get(seq).add(value);
			}

			if (queries.get(i).get(0) == 2) {
				lastAnswer = seqList.get(seq).get(value % seqList.get(seq).size());
				result.add(lastAnswer);
				System.out.println(lastAnswer);
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nq[0]);

		int q = Integer.parseInt(nq[1]);

		List<List<Integer>> queries = new ArrayList<>();

		for (int i = 0; i < q; i++) {
			String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> queriesRowItems = new ArrayList<>();

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
				queriesRowItems.add(queriesItem);
			}

			queries.add(queriesRowItems);
		}

		List<Integer> result = dynamicArray(n, queries);

		/*
		 * for (int i = 0; i < result.size(); i++) {
		 * bufferedWriter.write(String.valueOf(result.get(i)));
		 * 
		 * if (i != result.size() - 1) { bufferedWriter.write("\n"); } }
		 */
		bufferedReader.close();
		/*
		 * bufferedWriter.newLine();
		 * 
		 * 
		 * bufferedWriter.close();
		 */
	}
}
