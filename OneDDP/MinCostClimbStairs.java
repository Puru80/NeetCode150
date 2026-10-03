package OneDDP;

import java.util.*;
import java.io.*;

public class MinCostClimbStairs {

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

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n + 1];
        minCost[n] = 0;
        for(int i=0;i<n;i++){
            minCost[i] = cost[i];
        }

        for(int i=n-3;i>=0;i--){
            minCost[i] = Math.min(minCost[i] + minCost[i+1], minCost[i] + minCost[i+2]);
        }

        return Math.min(minCost[0], minCost[1]);
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] cost = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            pw.println(minCostClimbingStairs(cost));
        }

        pw.flush();
    }
}