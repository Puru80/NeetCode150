package OneDDP;

import java.util.*;
import java.io.*;

public class DecodeWays {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("/Users/purua/dev/Interview Prep/neetcode150/input.txt"));
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

    public static int dfs(String s, int i, Map<Integer, Integer> map) {
        if (map.containsKey(i)) {
            return map.get(i);
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfs(s, i + 1, map);
        if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, map);
        }

        map.put(i, res);

        return res;
    }

    public static int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s.length(), 1);

        return dfs(s, 0, map);
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(
                new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();
            pw.println(numDecodings(s));
        }

        pw.flush();
    }
}