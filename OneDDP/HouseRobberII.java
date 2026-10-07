package OneDDP;

import java.util.*;
import java.io.*;

public class HouseRobberII {

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

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int rob1 = 0, rob2 = 0;

        for(int i=0; i<nums.length - 1; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            
            rob1 = rob2;
            rob2 = temp;
        }

        int rob3 = 0, rob4 = 0;
        for(int i=1; i<nums.length;i++){
            int temp = Math.max(nums[i] + rob3, rob4);

            rob3 = rob4;
            rob4 = temp;
        }

        return Math.max(rob2, rob4);
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int nums[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(rob(nums));
        }

        pw.flush();
    }
}