import java.util.*;
import java.io.*;

public class BinaryTreeMaxPahSum {

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

    int res = Integer.MIN_VALUE;

    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getMax(node.left);
        int right = getMax(node.right);
        int path = node.val + Math.max(left, right);
        return Math.max(0, path);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return ;
        }

        int left = getMax(node.left);
        int right = getMax(node.right);
        res = Math.max(res, node.val + left + right);
        dfs(node.left);
        dfs(node.right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
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