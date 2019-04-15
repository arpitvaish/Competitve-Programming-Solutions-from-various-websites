
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    public static void main(String[] args) {

        FastReaderIO.FastReader reader = new FastReaderIO.FastReader();
        int t = reader.nextInt();
        List<Integer> arrayNumbers = new ArrayList<Integer>();
        double mean = 0.0d, sum = 0.0d, quartile1 = 0.0d, quartile2 = 0.0d, quartile3 = 0.0d;
        String elements = reader.nextLine();
        StringTokenizer st = new StringTokenizer(elements);
        String freq = reader.nextLine();
        StringTokenizer stFq = new StringTokenizer(freq); 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(st.nextToken());
            int fq= Integer.parseInt(stFq.nextToken());
            map.put(number,fq);
            for(int j=0;j<fq;j++){
                arrayNumbers.add(number);
            }

        }
        

        Collections.sort(arrayNumbers);
        int mid = arrayNumbers.size() / 2;
        if (arrayNumbers.size() % 2 != 0) {
            quartile1 = getMedian(arrayNumbers, 0, arrayNumbers.size());
            quartile2 = getMedian(arrayNumbers, 0, mid);
            quartile3 = getMedian(arrayNumbers, mid + 1, arrayNumbers.size());
        } else {
            quartile1 = getMedian(arrayNumbers, 0, arrayNumbers.size());
            quartile2 = getMedian(arrayNumbers, 0, mid);
            quartile3 = getMedian(arrayNumbers, mid, arrayNumbers.size());
        }

        System.out.println(quartile3 - quartile2);
        /*
         * System.out.println(quartile2); System.out.println(quartile1);
         * System.out.println(quartile3);
         */
    }

    static double getMedian(List<Integer> array, int start, int end) {
        double median = 0;
        
        // int a[] = Arrays.copyOfRange(array, start, end);
        List<Integer> subarray = new ArrayList<>(array.subList(start, end));
        int mid = (0 + subarray.size()) / 2;
        if (subarray.size() % 2 == 0) {
            median = (subarray.get(mid).doubleValue() + subarray.get(mid - 1).doubleValue()) / 2.0d;
        } else {
            median = subarray.get(mid).doubleValue();
        }
        return median;
    }
}

