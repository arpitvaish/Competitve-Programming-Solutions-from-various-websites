package com.sample.vault.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph {
	int V, E;
	Edge edge[];

	public Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < v; i++) {
			edge[i] = new Edge(0, 0, 0);
		}
	}

	class Subset {
		int parent, rank;

		@Override
		public String toString() {
			return "Subset [parent=" + parent + ", rank=" + rank + "]";
		}

	}

	class Edge implements Comparable<Edge> {
		int source;
		int destination;
		int weight;

		public Edge() {

		}

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return weight - e.weight;
		}

		@Override
		public String toString() {
			return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
		}

	}

	int find(Subset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;
	}

	void union(Subset subset[], int x, int y) {
		int xRoot = find(subset, x);
		int yRoot = find(subset, y);

		if (subset[xRoot].rank < subset[yRoot].rank) {
			subset[xRoot].parent = yRoot;
		} else if (subset[xRoot].rank > subset[yRoot].rank) {
			subset[yRoot].parent = xRoot;
		} else {
			subset[yRoot].parent = xRoot;
			subset[xRoot].rank++;
		}
	}
}

class Result {

	/*
	 * Complete the 'kruskals' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * WEIGHTED_INTEGER_GRAPH g as parameter.
	 */

	/*
	 * For the weighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is
	 * <name>Edges. 3. An edge exists between <name>From[i] and <name>To[i]. The
	 * weight of the edge is <name>Weight[i].
	 *
	 */

	public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		int totalWeight = 0;
		Graph graph = new Graph(gNodes, gFrom.size());
		Graph.Edge[] edges = new Graph.Edge[gFrom.size()];
		for (int i = 0; i < gFrom.size(); i++) {
			edges[i] = graph.new Edge(gFrom.get(i) - 1, gTo.get(i) - 1, gWeight.get(i));
		}

		Arrays.sort(edges);

		Graph.Edge result[] = new Graph.Edge[gNodes];
		Graph.Subset subsets[] = new Graph.Subset[gNodes];
		for (int i = 0; i < gNodes; i++) {
			result[i] = graph.new Edge();
			subsets[i] = graph.new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		int e = 0, r = 0;
		while (e < edges.length) {
			Graph.Edge ed = edges[e++];
			int x = graph.find(subsets, ed.source);
			int y = graph.find(subsets, ed.destination);
			if (x != y) {
				result[r++] = ed;
				totalWeight += ed.weight;
				graph.union(subsets, x, y);
			}

		}
		return totalWeight;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();
		List<Integer> gWeight = new ArrayList<>();

		for (int i = 0; i < gEdges; i++) {
			String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			gFrom.add(Integer.parseInt(gFromToWeight[0]));
			gTo.add(Integer.parseInt(gFromToWeight[1]));
			gWeight.add(Integer.parseInt(gFromToWeight[2]));
		}

		int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

		// Write your code here.
		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
