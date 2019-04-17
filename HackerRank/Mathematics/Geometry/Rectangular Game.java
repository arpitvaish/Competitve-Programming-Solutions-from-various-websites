//https://www.hackerrank.com/challenges/rectangular-game/problem
import java.io.IOException;
import java.util.Scanner;

public class Solutions {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] steps = new int[n][2];
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        for (int stepsRowItr = 0; stepsRowItr < n; stepsRowItr++) {
            String[] stepsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int stepsColumnItr = 0; stepsColumnItr < 2; stepsColumnItr++) {
                long stepsItem = Long.parseLong(stepsRowItems[stepsColumnItr]);
                if (stepsColumnItr == 0) {
                    if (stepsItem == Math.min(minY, stepsItem)) {
                        minY = stepsItem;
                    }
                } else {
                    if (stepsItem == Math.min(minX, stepsItem)) {
                        minX = stepsItem;
                    }
                }
            }
        }

        long result = minX * minY;
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
