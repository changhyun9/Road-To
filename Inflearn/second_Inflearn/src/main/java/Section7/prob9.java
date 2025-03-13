package Section7;

import java.io.*;
import java.util.*;

public class prob9 {

    public static void main(String[] args) throws IOException {
        Node9 root = new Node9(1);
        root.lt = new Node9(2);
        root.rt = new Node9(3);
        root.lt.lt = new Node9(4);
        root.lt.rt = new Node9(5);

        int answer = DFS(0, root);
        System.out.println(answer);
    }

    static int DFS(int L, Node9 node) {
        if (node.lt == null && node.rt == null) {
            return L;

        } else {
            return Math.min(DFS(L+1, node.lt), DFS(L+1, node.rt));
        }
    }
}

class Node9 {
    int data;
    Node9 lt;
    Node9 rt;

    public Node9(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
