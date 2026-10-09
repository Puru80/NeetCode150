package OneDDP;

import java.util.*;
import java.io.*;

public class CoinChange {

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

    private static int dfs(int[] coins, int amount, Map<Integer, Integer> dp) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }

        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dfs(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        dp.put(amount, minCoins);
        return minCoins;
    }

    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(amount + 1, 1);

        int ans = dfs(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] coins = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int amount = input.nextInt();

            pw.println(coinChange(coins, amount));
        }

        pw.flush();
    }
}