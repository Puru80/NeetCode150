package TwoDDP;

import java.util.*;
import java.io.*;

public class BuySellStock {

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

    Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    public int dfs(int i, boolean buying, int[] prices){
        if(i >= prices.length){
            return 0;
        }

        String key = i + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i + 1, buying, prices);
        if(buying){
            int buy = dfs(i+1, false, prices) - prices[i];
            dp.put(key, Math.max(cooldown, buy));
        }else{
            int sell = dfs(i+2, true, prices) + prices[i];
            dp.put(key, Math.max(cooldown, sell));
        }

        return dp.get(key);
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