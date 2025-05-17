import java.util.*;
import java.io.*;

public class SurroundedRegion {

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

    private void capture(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
                || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';
        capture(r + 1, c, board);
        capture(r - 1, c, board);
        capture(r, c + 1, board);
        capture(r, c - 1, board);
    }

    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;

        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == 'O') {
                capture(0, i, board);
            }
            if (board[ROWS - 1][i] == 'O') {
                capture(ROWS - 1, i, board);
            }
        }

        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == 'O') {
                capture(i, 0, board);
            }
            if (board[i][COLS - 1] == 'O') {
                capture(i, COLS - 1, board);
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}