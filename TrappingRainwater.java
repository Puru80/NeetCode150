import java.util.*;
import java.io.*;

public class TrappingRainwater {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("D:/Interview Prep/neetcode150/input.txt"));
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

    public static int trap(int[] height) {
        int n = height.length;
        int[] ends = new int[n];

        int max = height[0];
        for(int i=0;i<n;i++){
            max = Math.max(max, height[i]);
            ends[i] = max;
        }

        for (int i : ends) {
            pw.print(i + " ");
        }
        pw.println();

        max = height[n-1];
        for(int i=n-1; i>=0; i--){
            max = Math.max(max, height[i]);

            ends[i] = Math.min(max, ends[i]);
        }

        for(int i: ends){
            pw.print(i + " ");
        }

        pw.println();

        int ans = 0;
        for(int i=0;i<n;i++){
            if(ends[i] - height[i] > 0){
                ans += ends[i] - height[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int height[] = Arrays.stream(input.nextLine().trim().split(",")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(trap(height));
        }

        pw.flush();
    }
}