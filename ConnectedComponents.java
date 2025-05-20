import java.util.*;
import java.io.*;

public class ConnectedComponents {

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

    private Map<Integer, List<Integer>> adjMap = new HashMap<>();

    private void bfs(int node, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i : adjMap.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                bfs(i, visited);
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