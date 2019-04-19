
//https://www.hackerrank.com/challenges/circle-city/problem

import java.io.IOException;
import java.util.Scanner;

public class Solutions {

    // Complete the solve function below.
    static boolean solve(long d, long k) {

        long result = 0;
        for (int x = 0; x < Math.ceil(Math.sqrt(d)); x++) {
            double val = Math.sqrt(d - (x * x));
            if (val - Math.floor(val) == 0) {
                result += 4;
            }
        }
        return k >= result ? true : false;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] dk = scanner.nextLine().split(" ");

            long d = Integer.parseInt(dk[0]);

            long k = Integer.parseInt(dk[1]);

            String result = solve(d, k) ? "possible" : "impossible";
            System.out.println(result);
            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
        }

        //  bufferedWriter.close();

        scanner.close();
    }
}
