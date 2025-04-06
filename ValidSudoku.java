import java.util.*;
import java.io.*;

public class ValidSudoku {

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

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;

                String squareKey = (i / 3) + "," + (j / 3);

                if (rows.computeIfAbsent(i, k -> new HashSet<Character>()).contains(board[i][j])
                        || cols.computeIfAbsent(j, k -> new HashSet<Character>()).contains(board[i][j])
                        || square.computeIfAbsent(squareKey, k -> new HashSet<Character>()).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                square.get(squareKey).add(board[i][j]);

            }
        }

        return true;
    }

    public static char[][] convertToCharArray(String inputString) {
        // Remove the outermost brackets and split the string into a list of rows
        String[] rows = inputString.substring(2, inputString.length() - 2).split("\\],\\[");

        // Initialize an empty char array
        char[][] array = new char[rows.length][];

        // Iterate over the rows and their indices
        for (int i = 0; i < rows.length; i++) {
            // Remove any leading or trailing quotes and split the string into a list of
            // characters
            String[] chars = rows[i].replace("\"", "").split(",");

            // Add the characters to the char array
            array[i] = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {
                array[i][j] = chars[j].charAt(0);
            }
        }

        return array;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();

            char[][] board = convertToCharArray(s);

            /* for(char[] c: board){
                for(char cr: c){
                    pw.print(cr + " ");
                }

                pw.println();
            } */

            pw.println(isValidSudoku(board));
        }

        pw.flush();
    }
}