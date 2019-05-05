
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    // Usage example
    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str1 = scanner.readLine();
            int l1 = str1.length();
            String str2 = scanner.readLine();
            int l2 = str2.length();
            String str = str1 + "#" + str2 + "$";
            int[] sa = suffixArray(str);
            int[] lcp = lcp(sa, str);

            int n = str.length();
            int max = 0;
            for (int i = 1; i < n; i++) {
                if ((sa[i] < l1 && sa[i - 1] < n && sa[i - 1] > l1) || (sa[i] > l1 && sa[i] < n && sa[i - 1] < l1)) {
                    max = Math.max(max, lcp[i - 1]);
                }
            }
            if (max == 0) {
                System.out.println("No common sequence.");
                return;
            }
            for (int i = 1; i < n; i++) {
                if ((sa[i] < l1 && sa[i - 1] < n && sa[i - 1] > l1) || (sa[i] > l1 && sa[i] < n && sa[i - 1] < l1)) {
                    if (lcp[i - 1] == max) {
                        System.out.println(str.substring(sa[i], sa[i] + max));
                    }
                }
            }
            if (scanner.readLine() == null) {
                break;
            } else {
                System.out.println();
            }


        }


       /* for(int i=1; i<n; i++)
        {
            if((sa[i]<l1 && sa[i-1]<n && sa[i-1]>l1) || (sa[i]>l1 && sa[i]<n && sa[i-1]<l1))
                //maxi=max(maxi,LCP[i]);
        }*/
        /*int testCases = scanner.nextInt();
       // int[] sa1 = suffixArray(text);
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
           st.append(scanner.next());
        }
        st.append("$");

        int[] sa = suffixArray(st);
        for (int p : sa) System.out.print(p + " ");
        System.out.println();
         System.out.println("lcp = " + Arrays.toString(lcp(sa, st.toString())));*/


    }

    // sort suffixes of S in O(n*log(n))
    public static int[] suffixArray(CharSequence S) {
        int n = S.length();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = n - 1 - i;

        // stable sort of characters
        Arrays.sort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));

        int[] sa = new int[n];
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = order[i];
            classes[i] = S.charAt(i);
        }
        // sa[i] - suffix on i'th position after sorting by first len characters
        // classes[i] - equivalence class of the i'th suffix after sorting by
        // first len characters

        for (int len = 1; len < n; len *= 2) {
            int[] c = classes.clone();
            for (int i = 0; i < n; i++) {
                // condition sa[i - 1] + len < n simulates 0-symbol at the end
                // of the string
                // a separate class is created for each suffix followed by
                // simulated 0-symbol
                classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n
                        && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
            }
            // Suffixes are already sorted by first len characters
            // Now sort suffixes by first len * 2 characters
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++)
                cnt[i] = i;
            int[] s = sa.clone();
            for (int i = 0; i < n; i++) {
                // s[i] - order of suffixes sorted by first len characters
                // (s[i] - len) - order of suffixes sorted only by second len
                // characters
                int s1 = s[i] - len;
                // sort only suffixes of length > len, others are already sorted
                if (s1 >= 0)
                    sa[cnt[classes[s1]]++] = s1;
            }
        }
        return sa;
    }

    // sort rotations of S in O(n*log(n))
    public static int[] rotationArray(CharSequence S) {
        int n = S.length();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;
        Arrays.sort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));
        int[] sa = new int[n];
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = order[i];
            classes[i] = S.charAt(i);
        }
        for (int len = 1; len < n; len *= 2) {
            int[] c = classes.clone();
            for (int i = 0; i < n; i++)
                classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]]
                        && c[(sa[i - 1] + len / 2) % n] == c[(sa[i] + len / 2) % n] ? classes[sa[i - 1]] : i;
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++)
                cnt[i] = i;
            int[] s = sa.clone();
            for (int i = 0; i < n; i++) {
                int s1 = (s[i] - len + n) % n;
                sa[cnt[classes[s1]]++] = s1;
            }
        }
        return sa;
    }

    // longest common prefixes array in O(n)
    public static int[] lcp(int[] sa, CharSequence s) {
        int n = sa.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++)
            rank[sa[i]] = i;
        int[] lcp = new int[n - 1];
        for (int i = 0, h = 0; i < n; i++) {
            if (rank[i] < n - 1) {
                for (int j = sa[rank[i] + 1]; Math.max(i, j) + h < s.length()
                        && s.charAt(i + h) == s.charAt(j + h); ++h)
                    ;
                lcp[rank[i]] = h;
                if (h > 0)
                    --h;
            }
        }
        return lcp;
    }


    static void search(String pattern, String text, int[] sa) {
        List<Integer> result = new ArrayList<>();
        int min = 0;
        int max = text.length();
        int length = text.length();
        int patternLength = pattern.length();
        while (min < max) {
            int mid = (min + max) / 2;
            String suffix = text.substring(sa[mid], Math.min(sa[mid] + patternLength, length));
            if (pattern.compareTo(suffix) > 0) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        int start = min;
        max = text.length();
        while (min < max) {
            int mid = (min + max) / 2;
            String suffix = text.substring(sa[mid], Math.min(sa[mid] + patternLength, length));
            if (pattern.compareTo(suffix) < 0) {
                max = mid;
            } else {
                min = mid + 1;

            }
        }
        int end = max;
        if (start <= end) {
            for (int i = start; i < end; i++) {
                System.out.print(sa[i] + " ");
            }
        }

        //System.out.println(result);

    }

}
