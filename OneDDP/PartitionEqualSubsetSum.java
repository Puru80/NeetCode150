package OneDDP;

import java.util.*;
import java.io.*;

public class PartitionEqualSubsetSum {

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

    static Boolean[][] memo;

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }

        if(sum%2 != 0){
            return false;
        }

        memo = new Boolean[nums.length][sum/2 + 1];

        return dfs(nums, 0, sum/2);
    }

    public static boolean dfs(int[] nums, int i, int target){
        if(i == nums.length){
            return target == 0;
        }
        if(target < 0){
            return false;
        }

        if(memo[i][target] != null){
            return memo[i][target];
        }

        memo[i][target] =  dfs(nums, i + 1, target) || dfs(nums, i + 1, target - nums[i]);
        return memo[i][target];
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            pw.println(canPartition(nums));
        }

        pw.flush();
    }
}