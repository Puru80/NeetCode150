package Greedy;

import java.util.*;
import java.io.*;

public class HandOfStraights {

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

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> frequeMap = new HashMap<>();
        for(int i: hand){
            frequeMap.put(i, frequeMap.getOrDefault(i, 0) + 1);
        }

        for(int num: hand){
            if(frequeMap.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    if(frequeMap.getOrDefault(i, 0) == 0){
                        return false;
                    }
                    frequeMap.put(i, frequeMap.get(i) - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/purua/dev/Interview Prep/neetcode150/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] hand = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int groupSize = input.nextInt();

            pw.println(isNStraightHand(hand, groupSize));
        }

        pw.flush();
    }
}
