package Section7;

import java.io.*;
import java.util.*;

public class prob10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Leaf root = new Leaf(1);
        root.lt = new Leaf(2);
        root.rt = new Leaf(3);
        root.lt.lt = new Leaf(4);
        root.lt.rt = new Leaf(5);

        Queue<Leaf> queue = new LinkedList<>();

        queue.offer(root);

        int answer = Integer.MAX_VALUE;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Leaf poll = queue.poll();
                if(poll.lt != null) queue.offer(poll.lt);
                if(poll.rt != null) queue.offer(poll.rt);
                if (poll.lt == null && poll.rt == null) {
                    answer = Math.min(answer, L);
                }
            }
            L++;
        }
        System.out.println(answer);

    }
}

class Leaf {
    int val;
    Leaf lt, rt;

    public Leaf(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}