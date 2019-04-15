import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class Solution {
    private static List<Long> findComponents(ArrayList<Integer>[] arr, boolean[] visited) {

        List<Long> components = new ArrayList<>();
        long node = 0, nodes = 0;
        for (int i = 0; i < arr.length; i++) {

            if (!arr[i].isEmpty() && !visited[i]) {
                visited[i] = true;
                node = DFS(arr, visited, i, ++nodes);
                components.add(node);
                nodes=0;
            } else if (arr[i].isEmpty() && !visited[i]) {
                components.add(1L);
            }

        }

        return components;
    }

    private static long DFS(ArrayList<Integer>[] arr, boolean[] visited, int row, long nodes) {
        for (Integer num : arr[row]) {
            if (!arr[num].isEmpty() && !visited[num]) {
                visited[num] = true;
                nodes = DFS(arr, visited, num, ++nodes);
            }
        }
        return nodes;
    }

    public static void main(String[] args) throws IOException {

        FastReaderIO.FastReader fr = new FastReaderIO.FastReader();
        int q = fr.nextInt();

        for (int qItr = 0; qItr < q; qItr++) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            long c_lib = fr.nextLong();
            long c_road = fr.nextLong();
            long cost = 0;
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for (int i = 0; i < adjacencyList.length; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            if (c_lib < c_road || n == 1 || m == 0) {
                if (m > 0) {
                    for (int i = 0; i < m; i++)
                        fr.nextLine();
                }
                cost = (long) n * c_lib;
            } else {

                boolean[] visisted = new boolean[n];
                int citiesItem1 = 0, citiesItem2 = 0;
                for (int i = 0; i < m; i++) {
                    citiesItem1 = fr.nextInt();
                    citiesItem2 = fr.nextInt();
                    adjacencyList[citiesItem1 - 1].add(citiesItem2 - 1);
                    adjacencyList[citiesItem2 - 1].add(citiesItem1 - 1);
                }

                long disconnectComponents = 0;

                List<Long> listOfComponents = new ArrayList<>();
                listOfComponents = findComponents(adjacencyList, visisted);
                for (Long component : listOfComponents) {
                    if (component == 1) {
                        cost += c_lib;
                    } else {
                        cost += (component - 1) * c_road + c_lib;
                    }
                }
            }
            System.out.println(cost);
        }
    }

}   
