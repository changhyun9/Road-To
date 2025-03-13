package Section7;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException {
        Node10 root = new Node10(1);
        root.lt = new Node10(2);
        root.rt = new Node10(3);
        root.lt.lt = new Node10(4);
        root.lt.rt = new Node10(5);

        int answer = Integer.MAX_VALUE, L=0;

        Queue<Node10> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node10 poll = queue.poll();
                if (poll.lt == null && poll.rt == null) {
                    answer = Math.min(answer, L);
                    break;
                }
                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }
            L++;
        }
        System.out.println(answer);
    }
}

class Node10 {
    int data;
    Node10 lt;
    Node10 rt;

    public Node10(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}