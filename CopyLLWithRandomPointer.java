import java.util.*;
import java.io.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLLWithRandomPointer {

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

    /* public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    } */

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;
        while (curr != null) {
            if(!map.containsKey(curr)){
                map.put(curr, new Node(0));
            }
            map.get(curr).val = curr.val;

            if(!map.containsKey(curr.next)){
                map.put(curr.next, new Node(0));
            }
            map.get(curr).next = map.get(curr.next);

            if(!map.containsKey(curr.random)){
                map.put(curr.random, new Node(0));
            }
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
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