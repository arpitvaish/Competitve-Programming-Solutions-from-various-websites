import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

      static List<Integer> bfs(int n, int m, int[][] edges, int s) {

        int result[] = null;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i= 0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        //add edge
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]-1].add(edges[i][1]);
            graph[edges[i][1]-1].add(edges[i][0]);
        }
        
        result = shortestReach(graph, s);
       List<Integer> output = new ArrayList<>();
        for(int i=0;i<result.length;i++){
            
            if(s-1 == i)
                continue;
            output.add(result[i]);
        }
        
        return output;
    }
    
   public static int[] shortestReach(List<Integer>[] graph, int s){
        
        int[] distances = new int[graph.length];
        Arrays.fill(distances, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        distances[s-1] = 0;
        q.offer(s);
        while(!q.isEmpty()){
            int node = q.poll();
            //visit neighbours of node
            for(int neighbour:graph[node-1]){
                if(distances[neighbour-1] == -1){
                    distances[neighbour-1] = distances[node-1]+6;
                    q.offer(neighbour);
                }
            }
        }
        
        
        return distances;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<Integer> result = bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
