package com.sample.vault.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastReader {
	static class FastReaderIO {
		BufferedReader br;
		StringTokenizer st;

		public FastReaderIO() {
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

public class Solution {

	public static void main(String[] args) {

		FastReader.FastReaderIO reader = new FastReader.FastReaderIO();
		int t = reader.nextInt();
		double[] arrayNumbers = new double[t];
		double[] arrayWeights = new double[t];
		double mean = 0.0d, sum = 0.0d, sumOfWeight = 0.0d;
		for (int i = 0; i < t; i++) {
			double num = reader.nextDouble();
			arrayNumbers[i] = num;
		}
		for (int i = 0; i < t; i++) {
			double num = reader.nextDouble();
			arrayWeights[i] = num;
			sumOfWeight += num;
		}

		for (int i = 0; i < t; i++) {
			sum += arrayNumbers[i] * arrayWeights[i];
		}

		System.out.printf("%.1f \n", (sum / sumOfWeight));

	}
}
