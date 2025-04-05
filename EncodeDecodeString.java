import java.util.*;
import java.io.*;

public class EncodeDecodeString {

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

    public static String encode(List<String> strs) {
        if (strs.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int len = s.length();

            sb.append(len);
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                length = length * 10 + (c - '0');
            } else if (c == '#') {
                res.add(str.substring(i + 1, i + length + 1));

                i = i + length;
                length = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            List<String> list = Arrays.stream(input.nextLine().split(" "))
                    .toList();

            String encodedString = encode(list);
            pw.println(encodedString);

            List<String> res = decode(encodedString);
            for (String s : res) {
                pw.print(s + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}