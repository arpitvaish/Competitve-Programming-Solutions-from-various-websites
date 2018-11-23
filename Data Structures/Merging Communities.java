class Node {
	int rank;
	long data;
	int size;
	Node parent;

	public Node() {

	}

	public Node(long data) {
		this.rank = 0;
		this.data = data;
		this.size = 1;
		this.parent = this;
	}

	@Override
	public String toString() {
		return "Node [rank=" + rank + ", data=" + data + ", size=" + size + ", parent= " + parent.data + "]";
	}

}

public class Solution {

	public static Map<Long, Node> map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		FastReaderIO.FastReader fr = new FastReaderIO.FastReader();
		int n = fr.nextInt();
		int q = fr.nextInt();
		makeSet(n);
		for (int i = 0; i < q; i++) {
			String type = fr.next();
			if (type.equals("Q")) {
				int search = fr.nextInt();
				System.out.println(size(search - 1));
			}
			if (type.equals("M")) {
				int set1 = fr.nextInt() - 1;
				int set2 = fr.nextInt() - 1;
				union(set1, set2);
			}
		}
	}

	public static void makeSet(long n) {
		for (long i = 0; i < n; i++) {
			Node node = new Node(i);
			map.put(i, node);
		}

	}

	static long countdata(long num) {
		int count = 0;
		long parent = find(num);
		Node node = map.get(parent);
		for (Entry<Long, Node> data : map.entrySet()) {
			if (data.getValue().parent.data == parent) {
				count++;
			}
		}
		return count;
	}

	static long find(long num) {
		return findSet(map.get(num)).data;
	}

	static long size(long num) {
		return findSet(map.get(num)).size;
	}

	static Node findSet(Node node) {

		Node parent = node.parent;
		if (parent == node) {
			return parent;
		}
		Node result = findSet(node.parent);
		node.parent = result;
		return result;

	}

	static void union(long a, long b) {

		Node nodeA = map.get(a);
		Node nodeB = map.get(b);
		Node nodeAParent = findSet(nodeA);
		Node nodeBParent = findSet(nodeB);

		if (nodeAParent.parent == nodeBParent.parent) {
			return;
		}

		if (nodeAParent.rank > nodeBParent.rank) {
			nodeBParent.parent = nodeAParent;
			nodeAParent.size += nodeBParent.size;

		}
		if (nodeAParent.rank < nodeBParent.rank) {
			nodeAParent.parent = nodeBParent.parent;
			nodeBParent.size += nodeAParent.size;
		}
		
		if(nodeAParent.rank == nodeBParent.rank){
			nodeAParent.rank++;
			nodeBParent.parent = nodeAParent;
			nodeAParent.size += nodeBParent.size;
		}

	}

}
