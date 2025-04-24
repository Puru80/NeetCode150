import java.util.*;
import java.io.*;

public class KokoEatingBananas {

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

    static int findMax(int[] piles) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }

    static int getTimeTaken(int[] piles, int k) {
        int res = 0;

        for (int p : piles) {
            res += Math.ceil((double) p / k);
        }

        return res;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);
        int l = 1, r = max;
        int res = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = getTimeTaken(piles, mid);

            if (time > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] piles = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int h = input.nextInt();

            pw.println(minEatingSpeed(piles, h));
        }

        pw.flush();
    }
}
