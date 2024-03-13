package Section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7 {
    /**
     * 나의 구현방법
     */
    Node root;
    public static void main(String[] args) {
        Q7 tree = new Q7();
        // binary tree 생성
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        BFS(tree.root);

    }

    public static void BFS(Node root) {
        // 넓이 우선 탐색을 하기 위해 Queue 생성
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            System.out.print(L + " : ");
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
}
