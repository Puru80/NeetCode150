import java.util.*;
import java.io.*;

public class LongestRepeatingCharRep {

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

    public static int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int res = 0;

        for (char c : set) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                if(s.charAt(r) == c){
                    count++;
                }

                while( (r-l+1)-count > k){
                    if(s.charAt(l) == c){
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l +1);
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();
            int k = input.nextInt();

            pw.println(characterReplacement(s, k));
        }

        pw.flush();
    }
}