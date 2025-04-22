package Section7;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Tree root = new Tree(1);
        root.lt = new Tree(2);
        root.rt = new Tree(3);
        root.lt.lt = new Tree(4);
        root.lt.rt = new Tree(5);
        root.rt.lt = new Tree(6);
        root.rt.rt = new Tree(7);

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Tree poll = queue.poll();
                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
                System.out.print(L + " : " + poll.val+" ");
            }
            System.out.println();
            L++;
        }

    }
}

class Tree {

    int val;
    Tree lt,rt;

    public Tree(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}
