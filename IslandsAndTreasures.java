import java.util.*;
import java.io.*;

public class IslandsAndTreasures {

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

    private int[][] directions = { { 1, 0 }, { -1, 0 },
            { 0, 1 }, { 0, -1 } };
    private int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for(int[] d: directions){
                int x = r + d[0];
                int y = c + d[1];

                if(x < 0 || y < 0 || x>=n || y>= m || grid[x][y] != INF){
                    continue;
                }

                q.add(new int[]{x, y});
                grid[x][y] = grid[r][c] + 1;   
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