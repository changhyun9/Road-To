package Section7;

public class Q9 {
    /**
     * 풀이방법
     * DFS는 사실 최단 거리를 구하는 로직으로는 적합하지 않다.
     * 그래도 이진트리에서 말단노드, 즉 자식이없는 노드를 만나면 해당
     * 노드의 레벨을 반환한다. 그래서 양쪽 노드에서 반환된 값 중 작은
     * 값이 최단 거리가 된다.
     */
    Node root;
    public static void main(String[] args) {
        Q9 tree = new Q9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(DFS(0, tree.root));
    }

    public static int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }

}
