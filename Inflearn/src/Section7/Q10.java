package Section7;

import java.util.LinkedList;
import java.util.Queue;

public class Q10 {
    /**
     * 풀이방법
     * Queue를 생성하고, 동일한 레벨에 있는 요소들을 Queue에
     * 삽입하고, 하나씩 꺼내서 조건을 만족하는지 탐색
     * 조건을 만족하는 것이 있다면 해당 레벨을 반환하고,
     * 그렇지 않으면 다음 레벨에 해당하는 요소를 Queue에 삽입하고
     * 해당 로직을 다시 실행
     */
    Node root;
    public static void main(String[] args) {
        Q10 tree = new Q10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(BFS(tree.root));
    }

    public static int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node poll = q.poll();
                if (poll.lt == null && poll.rt == null) {
                    return L;
                }
                if (poll.lt != null) {
                    q.offer(poll.lt);
                }
                if (poll.rt != null) {
                    q.offer(poll.rt);
                }
            }
            L++;
        }
        return -1;
    }
}
