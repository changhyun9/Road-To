package Section7;

import java.io.*;
import java.util.*;

public class prob7 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node7 root = new Node7(1);
        root.lt = new Node7(2);
        root.rt = new Node7(3);
        root.lt.lt = new Node7(4);
        root.lt.rt = new Node7(5);
        root.rt.lt = new Node7(6);
        root.rt.rt = new Node7(7);

        Queue<Node7> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node7 poll = queue.poll();
            System.out.print(poll.data + " ");
            if (poll.lt != null) {
                queue.offer(poll.lt);
            }
            if (poll.rt != null) {
                queue.offer(poll.rt);
            }
        }


    }

}

class Node7{
    Node7 lt = null;
    Node7 rt = null;
    int data;

    public Node7(int data) {
        this.data = data;
    }

}
