import java.util.*;
import java.io.*;

public class PacificAtlanicWaterFlow {

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

    private int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {
        ocean[r][c] = true;

        for (int[] d : directions) {
            int x = r + d[0];
            int y = c + d[1];

            if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length &&
                    !ocean[x][y] && heights[x][y] >= heights[r][c]) {
                dfs(x, y, heights, ocean);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int i = 0; i < COLS; i++) {
            dfs(0, i, heights, pac);
            dfs(ROWS - 1, i, heights, atl);
        }

        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, heights, pac);
            dfs(i, COLS - 1, heights, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
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