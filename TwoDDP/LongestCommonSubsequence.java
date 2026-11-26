package TwoDDP;

import java.util.*;
import java.io.*;

public class LongestCommonSubsequence {

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

    int[][] memo;

    public int longestCommonSubsequence(String st1, String st2) {
        memo = new int[st1.length()][st2.length()];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return dfs(st1, st2, 0, 0);
    }

    public int dfs(String st1, String st2, int i, int j) {
        if (i == st1.length() || j == st2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (st1.charAt(i) == st2.charAt(j)) {
            memo[i][j] = 1 + dfs(st1, st2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dfs(st1, st2, i + 1, j),
                    dfs(st1, st2, i, j + 1));
        }

        return memo[i][j];
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}