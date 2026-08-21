import java.util.*;
import java.io.*;

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        minHeap.offer(num);

        if (minHeap.size() - maxHeap.size() > 1 ||
                !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}

public class MedianFromDS {

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

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {

        }

        pw.flush();
    }
}