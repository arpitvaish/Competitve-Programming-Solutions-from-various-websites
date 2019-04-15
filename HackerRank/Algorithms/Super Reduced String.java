import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {

	// Complete the superReducedString function below.
	static String superReducedString(String s) {

		String regex = "(.)\\1";
		Pattern p = Pattern.compile(regex);
		while (true) {
			Matcher m = p.matcher(s);
			if (m.find() == true) {
				s = s.replace(m.group(), "");
			} else {
				break;
			}
		}
		if (s.trim().isEmpty()) {
			return "Empty String";
		}
		return s.trim();

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		String result = superReducedString(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
