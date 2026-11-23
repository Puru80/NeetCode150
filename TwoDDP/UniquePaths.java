package TwoDDP;

import java.util.*;
import java.io.*;

public class UniquePaths {

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

    static int[][] memo;

    public static int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] it : memo) {
            Arrays.fill(it, -1);
        }
        return dfs(0, 0, m, n);

    }

    private static int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(
                new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] params = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            pw.println(uniquePaths(params[0], params[1]));
        }

        pw.flush();
    }
}