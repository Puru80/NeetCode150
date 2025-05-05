import java.util.*;
import java.io.*;

public class MedianTwoSortedArrays {

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

    /*
     * public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
     * int n = nums1.length, m = nums2.length;
     * 
     * int mid = (n + m) / 2;
     * 
     * int i = 0, j = 0, m1 = 0, m2 = 0;
     * for (int k = 0; k <= mid; k++) {
     * m2 = m1;
     * if (i != n && j != m) {
     * if (nums1[i] >= nums2[j]) {
     * m1 = nums2[j++];
     * } else {
     * m1 = nums1[i++];
     * }
     * } else if (i < n) {
     * m1 = nums1[i++];
     * } else {
     * m1 = nums2[j++];
     * }
     * }
     * 
     * if ((n + m) % 2 == 0) {
     * double ans = (double) m1 + (double) m2;
     * return ans / 2;
     * } else {
     * return (double) m1;
     * }
     * }
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        return 0;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] nums1 = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int[] nums2 = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            pw.println(findMedianSortedArrays(nums1, nums2));
        }

        pw.flush();
    }
}