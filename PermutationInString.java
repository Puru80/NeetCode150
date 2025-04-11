import java.util.*;
import java.io.*;

public class PermutationInString {

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

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(count1, 0) + 1);
        }

        int need = count1.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int cur = 0;

            for(int j=i; j<s2.length();j++){
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                if(count1.getOrDefault(c, 0) < count2.get(c)){
                    break;
                }

                if(count1.getOrDefault(c, 0) == count2.get(c)){
                    cur++;
                }

                if(cur==need){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkInclusionOpt(String s1, String s2){
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s1 = input.nextLine();
            String s2 = input.nextLine();

            pw.println(checkInclusion(s1, s2));
        }

        pw.flush();
    }
}