//https://www.hackerrank.com/challenges/sherlock-and-planes/problem
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solutions {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int[][] points = new int[4][3];
            Set<Integer> x = new HashSet<>();
            Set<Integer> y = new HashSet<>();
            Set<Integer> z = new HashSet<>();
            for (int pointsRowItr = 0; pointsRowItr < 4; pointsRowItr++) {
                String[] pointsRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                x.add(Integer.parseInt(pointsRowItems[0]));
                y.add(Integer.parseInt(pointsRowItems[1]));
                z.add(Integer.parseInt(pointsRowItems[2]));


            }


            String result = "NO";
            if (x.size() == 1 || y.size() == 1 || z.size() == 1) {
                result = "YES";
            }

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
