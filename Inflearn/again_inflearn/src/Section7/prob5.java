package Section7;

import java.io.*;
import java.util.*;

public class prob5 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        DFS(root);

    }

    static void DFS(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.val+ " ");
            DFS(node.lt);
            DFS(node.rt);
        }
    }
}

class Node {
    int val;
    Node lt;
    Node rt;

    public Node(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}