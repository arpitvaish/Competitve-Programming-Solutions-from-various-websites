import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class NodeT {
    int data;
    int depth;
    NodeT left;
    NodeT right;

    public NodeT(int data, int depth) {
        this.data = data;
        this.depth = depth;
        left = null;
        right = null;
    }
}

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static List<Integer> arrayInOrder = null;
    static Integer[][] swapNodes(NodeT root, int[] queries) {

        int temp1 = Integer.MIN_VALUE, temp2 = Integer.MIN_VALUE;
        Integer[][] swappedNode = new Integer[queries.length][];
        int i = 0;
        for (int query : queries) {
            NodeT node = swap(root, query);
            arrayInOrder = new ArrayList<>();
            inOrderTraversal(root);
            swappedNode[i] = arrayInOrder.toArray(new Integer[arrayInOrder.size()]);
            i++;
        }
        
        return swappedNode;
    }
    
    static NodeT swap(NodeT root, int k) {

        NodeT temp = null;
        if (root.left == null && root.right == null) {
            return root;
        }
        // while(root != null){
        if (root.depth % k == 0) {

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.left != null)
        swap(root.left, k);
        
        if(root.right != null)
        swap(root.right, k);
        // }

        return root;
    }
    
    static NodeT createBST(int[][] indexes) {

        Queue<NodeT> q = new LinkedList<>();
        NodeT root = new NodeT(1, 1);
        NodeT cur = root;
        q.offer(cur);
        int N = indexes.length;
        for (int[] index : indexes) {
            cur = q.poll();
            int leftData = index[0];
            int rightData = index[1];

            cur.left = (leftData == -1) ? null : new NodeT(leftData, cur.depth + 1);
            cur.right = (rightData == -1) ? null : new NodeT(rightData, cur.depth + 1);

            if (cur.left != null && cur.left.data != -1)
                q.offer(cur.left);

            if (cur.right != null && cur.right.data != -1)
                q.offer(cur.right);

        }
        return root;
    }
    
    static void inOrderTraversal(NodeT root) {

        if (root == null)
            return;
        inOrderTraversal(root.left);
        arrayInOrder.add(root.data);
        inOrderTraversal(root.right);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }
        NodeT root = createBST(indexes);
        Integer[][] result = swapNodes(root, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
