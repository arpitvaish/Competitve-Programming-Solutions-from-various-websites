//Note : This solution is not a perfect solution as it passes on 6 test cases, hence work in progress.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

	static FastScanner scanner = new FastScanner(System.in);
	static double totalWayCount = 0, successWayCount = 0;
	static int Ax = -1, Ay = -1;
	static int[] xAxis = { -1, 1, 0, 0, 1, -1, -1, 1 };
	static int[] yAxis = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static boolean tunnelled = false;
	static Map<Integer, Integer> tunnelMap = new HashMap<>();

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
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
	}

	public static void main(String[] args) {

		int n = scanner.nextInt();

		int m = scanner.nextInt();

		int k = scanner.nextInt();
		boolean[][] visited = new boolean[n][m];

		int[][] AdjM = new int[n][m];
		for (int nItr = 0; nItr < n; nItr++) {
			String[] mVal = scanner.next().split("");
			for (int mItr = 0; mItr < m; mItr++) {
				int v = -1;
				if (mVal[mItr].equals("#")) {
					v = -1;
				} else if (mVal[mItr].equals("*")) {
					v = -2;
				} else if (mVal[mItr].equals("A")) {
					v = 100;
					Ax = nItr;
					Ay = mItr;
				} else if (mVal[mItr].equals("%")) {
					v = 200;
				} else {
					v = 0;
				}
				AdjM[nItr][mItr] = v;
			}
			// Write Your Code Here
		}
		for (int kItr = 0; kItr < k; kItr++) {

			int i1 = scanner.nextInt();

			int j1 = scanner.nextInt();

			int i2 = scanner.nextInt();

			int j2 = scanner.nextInt();

			AdjM[i1 - 1][j1 - 1] = 0;
			AdjM[i2 - 1][j2 - 1] = 0;
			tunnelMap.put((i1 - 1) * 10 + (j1 - 1), (i2 - 1) * 10 + (j2 - 1));
			tunnelMap.put((i2 - 1) * 10 + (j2 - 1), (i1 - 1) * 10 + (j1 - 1));

		}

		DFS(AdjM, visited);
		// System.out.println("Success count" + successWayCount);
		// System.out.println("Total count" + totalWayCount);
		// System.out.println("probability" + (double)(successWayCount /
		// totalWayCount));
		System.out.printf("%.2f", successWayCount / totalWayCount);

	}

	static void DFS(int[][] AdjM, boolean[][] visited) {
		for (int i = 0; i < xAxis.length; i++) {
			if (Ax + xAxis[i] >= 0 && Ay + yAxis[i] >= 0 && Ax + xAxis[i] < AdjM.length
					&& Ay + yAxis[i] < AdjM[0].length && visited[Ax + xAxis[i]][Ay + yAxis[i]] == false) {
				dfsVISIT(AdjM, Ax + xAxis[i], Ay + yAxis[i], visited);
			}
		}
	}

	static void dfsVISIT(int[][] AdjM, int x, int y, boolean[][] visited) {
		if (x < 0 || y < 0 || x > AdjM.length - 1 || y > AdjM[0].length - 1) {
			return;
		}
		visited[x][y] = true;
		if (AdjM[x][y] == -2) {
			totalWayCount += 1;
			return;
		}
		if (AdjM[x][y] == -1) {
			return;
		}
		if (AdjM[x][y] == 200) {
			totalWayCount += 1;
			successWayCount += 1;
			return;
		}
		if (tunnelMap.keySet().contains(x * 10 + y) && tunnelled == false) {
			int coordinates = tunnelMap.get(x * 10 + y);
			int xCord = coordinates / 10;
			int yCord = coordinates % 10;
			tunnelled = true;
			dfsVISIT(AdjM, xCord, yCord, visited);
		}

		boolean unset = false;
		for (int i = 0; i < xAxis.length; i++) {
			int tempX = x + xAxis[i];
			int tempY = y + yAxis[i];
			if (tempX < 0 || tempY < 0 || tempX > AdjM.length - 1 || tempY > AdjM[0].length - 1) {
				continue;
			}
			if (AdjM[tempX][tempY] != -1) {
				unset = true;
				break;
			}

		}
		if (unset == false) {
			totalWayCount += 1;
		}

		for (int i = 0; i < xAxis.length; i++) {
			if (x + xAxis[i] >= 0 && y + yAxis[i] >= 0 && x + xAxis[i] < AdjM.length && y + yAxis[i] < AdjM.length
					&& visited[x + xAxis[i]][y + yAxis[i]] == false) {
				dfsVISIT(AdjM, x + xAxis[i], y + yAxis[i], visited);
			}
		}
	}

}
