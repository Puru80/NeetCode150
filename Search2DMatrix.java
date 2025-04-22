import java.util.*;
import java.io.*;

public class Search2DMatrix {

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

    // Staircase
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (matrix[r][c] < target) {
                r++;
            } else if (matrix[r][c] > target) {
                c--;
            } else
                return true;
        }

        return false;
    }

    public static boolean searchMatrixBS(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else
                break;
        }

        if (!(top <= bot)) {
            return false;
        }

        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else
                return true;
        }

        return false;
    }

    public static boolean searchMatrixBSOnePass(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / COLS, col = mid % COLS;
            if (matrix[row][col] > target) {
                r = mid - 1;
            } else if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
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