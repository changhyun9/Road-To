package Section7;

import java.util.Scanner;

public class Q5 {
    /**
     * 나의 구현방법
     */
    Node root;
    public static void main(String[] args) {
        Q5 tree = new Q5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        DFS(tree.root);
    }

    public static void DFS(Node root) {
        if (root == null) {
            return;
        }
        else {
            // System.out.print(root.data + " "); // 여기서 출력하면 전위
            DFS(root.lt);
            System.out.print(root.data + " "); // 여기서 출력하면 중위
            DFS(root.rt);
            // System.out.print(root.data + " "); // 여기서 출력하면 후위
        }
    }

}

class Node{
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}
