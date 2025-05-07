import java.util.*;
import java.io.*;

public class KthSmallestBST {

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

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }

    private void dfs(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }

        dfs(node.left, tmp);
        tmp[0] -= 1;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }
        dfs(node.right, tmp);
    }

    /*
     * public int kthSmallest(TreeNode root, int k) {
     * List<Integer> list = new ArrayList<>();
     * inOrderTraversal(root, list);
     * 
     * return list.get(k - 1);
     * }
     */

    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
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