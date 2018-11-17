import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int source;
	int destination;
	int weight;

	public Edge() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destination;
		result = prime * result + source;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (destination != other.destination)
			return false;
		if (source != other.source)
			return false;
		return true;
	}

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}

}

public class Solution {

	static double PI = 3.1415926535;
	static PrintWriter out = new PrintWriter(System.out);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static int getMinIndex(int[] distances, boolean[] visited) {

		int minIndex = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < distances.length; i++) {
			if (!visited[i] && distances[i] != Integer.MAX_VALUE) {
				if (distances[i] < min) {
					min = distances[i];
					minIndex = i;
				}
			}
		}

		return minIndex;
	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// initialize data structures
			int[] distances = new int[n];
			ArrayList<Edge>[] adjacencyList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				distances[i] = Integer.MAX_VALUE;
				adjacencyList[i] = new ArrayList<Edge>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				int w = Integer.parseInt(st.nextToken());
				Edge newE = new Edge(u, v, w);
				Edge revE = new Edge(v, u, w);
				if (u != v) {
					if (adjacencyList[u].contains(newE)) {
						int index = adjacencyList[u].indexOf(newE);
						int index2 = adjacencyList[v].indexOf(revE);
						if (adjacencyList[u].get(index).weight > newE.weight
								|| adjacencyList[v].get(index2).weight > newE.weight) {
							adjacencyList[u].remove(index);
							adjacencyList[v].remove(index2);

						} else {
							continue;
						}

					}
					adjacencyList[u].add(newE);
					adjacencyList[v].add(revE);
				}
			}

			int s = Integer.parseInt(br.readLine()) - 1;

			Queue<Integer> unsettledNodes = new LinkedList<>();
			boolean visited[] = new boolean[n];
			List<Integer> settledNodes = new ArrayList<>();
			// initialize source
			unsettledNodes.offer(s);
			distances[s] = 0;

			while (!unsettledNodes.isEmpty()) {
				int node = unsettledNodes.poll();
				visited[node] = true;

				for (Edge edge : adjacencyList[node]) {
					int weight = edge.weight;
					if (!visited[edge.destination] && distances[node] + weight < distances[edge.destination]) {
						distances[edge.destination] = distances[node] + weight;

					}
				}

				settledNodes.add(node);
				if (settledNodes.size() <= n) {
					int minNode = getMinIndex(distances, visited);
					unsettledNodes.offer(minNode);
				}

			}
			// System.out.println(distances);

			List<Integer> distance1 = new ArrayList<Integer>();
			for (int i = 0; i < distances.length; i++) {
				if (i == s)
					continue;
				System.out.print((distances[i] == Integer.MAX_VALUE ? -1 : distances[i]) + " ");
				distance1.add(distances[i]);
			}
			System.out.println();

		}

		// bufferedWriter.close();
		br.close();
		out.close();
	}

}
