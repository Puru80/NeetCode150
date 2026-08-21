import java.util.*;
import java.io.*;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class ReverseLinkedList {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("/Users/purua/dev/Interview Prep/neetcode150/input.txt"));
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

    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        
        return prev;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}