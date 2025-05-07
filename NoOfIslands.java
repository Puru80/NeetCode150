import java.util.*;
import java.io.*;

public class NoOfIslands {

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

    private void bfs(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        grid[i][j] = '0';

        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] d: directions){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x < 0 || y < 0 || y >= m || x >= n){
                    continue;
                }

                if(grid[x][y] == '1'){
                    q.add(new int[]{x, y});
                    grid[x][y] = '0';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
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