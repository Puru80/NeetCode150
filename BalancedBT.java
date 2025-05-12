import java.util.*;
import java.io.*;

public class BalancedBT {

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

    private boolean isBalanced = true;

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = 1 + dfs(node.left);
        int rightHeight = 1 + dfs(node.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
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