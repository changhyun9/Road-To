package 덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class p10866 {
    /**
     * 나의 풀이 방법 : 간단하게 Deque를 이용하여 구현.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            if (input[0].equals("push_back")) {
                deque.offerLast(Integer.parseInt(input[1]));
            } else if (input[0].equals("push_front")) {
                deque.offerFirst(Integer.parseInt(input[1]));
                
            } else if (input[0].equals("pop_front")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.pollFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (input[0].equals("pop_back")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.pollLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
                
            } else if (input[0].equals("size")) {
                bw.write(deque.size()+"\n");
                
            } else if (input[0].equals("empty")) {
                if (!deque.isEmpty()) {
                    bw.write( "0\n");
                } else {
                    bw.write("1\n");
                }
                
            } else if (input[0].equals("front")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.getFirst()+ "\n");
                } else {
                    bw.write("-1\n");
                }

            } else {
                if (!deque.isEmpty()) {
                    bw.write(deque.getLast()+ "\n");
                } else {
                    bw.write("-1\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

}
