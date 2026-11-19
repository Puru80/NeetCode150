package OneDDP;

import java.util.*;
import java.io.*;

public class LongestIncreasingSubseq {

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

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(-1, 0, nums);
    }

    public static int dfs(int j, int i, int[] nums){
        if(i == nums.length){
            return 0;
        }

        if(memo[i][j+1] != -1){
            return memo[i][j+1];
        }

        int LIS = dfs(j, i+1, nums); //not include

        if(j == -1 || nums[j] < nums[i]){
            LIS = Math.max(LIS, 1 + dfs(i, i+1, nums)); //include
        }

        memo[i][j+1] = LIS;

        return LIS;
    }
    
    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            
            pw.println(lengthOfLIS(nums));
        }

        pw.flush();
    }
}
