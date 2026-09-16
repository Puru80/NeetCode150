package Bactracking;

import java.util.*;
import java.io.*;

public class PhoneNumberLetterComb {

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

    public Map<Character, String> digitMap = Map.ofEntries(
            Map.entry('2', "abc"),
            Map.entry('3', "def"),
            Map.entry('4', "ghi"),
            Map.entry('5', "jkl"),
            Map.entry('6', "mno"),
            Map.entry('7', "pqrs"),
            Map.entry('8', "tuv"),
            Map.entry('9', "wxyz"));

    public void dfs(String digits, StringBuilder combi, List<String> res, int i) {
        if (i >= digits.length()) {
            res.add(combi.toString());
            return;
        }

        String cur = digitMap.get(digits.charAt(i));

        for (int j = 0; j < cur.length(); j++) {
            combi.append(cur.charAt(j));
            dfs(digits, combi, res, i + 1);
            combi.deleteCharAt(combi.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder combi = new StringBuilder();

        if (digits.length() == 0) {
            return res;
        }

        dfs(digits, combi, res, 0);

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(
                new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}
