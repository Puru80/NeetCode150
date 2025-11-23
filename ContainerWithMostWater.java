import java.util.*;
import java.io.*;

public class ContainerWithMostWater {

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

    public static int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n - 1;

        int ans = 0;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            ans = Math.max(ans, area);

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] heights = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(maxArea(heights));
        }

        pw.flush();
    }
}