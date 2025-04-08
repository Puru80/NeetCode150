import java.util.*;
import java.io.*;

public class LongestSubstringWithoutRepChar {

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

    /* public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    } */

    //Optimal sol
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int l=0, res=0;

        for(int r=0;r<s.length();r++){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }

            map.put(s.charAt(r), r);
            res = Math.max(res, r - l +1);
        }
        return res;
    }


    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();

            pw.println(lengthOfLongestSubstring(s));
        }

        pw.flush();
    }
}
