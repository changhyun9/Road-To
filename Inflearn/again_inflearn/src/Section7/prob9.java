package Section7;

public class prob9 {

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Wood root = new Wood(1);
        root.lt = new Wood(2);
        root.rt = new Wood(3);
        root.lt.lt = new Wood(4);
        root.lt.rt = new Wood(5);

        DFS(0,root);

        System.out.println(answer);
    }

    static void DFS(int L, Wood root) {
        if (root.lt == null && root.rt == null) {
            answer = Math.min(answer, L);
        } else {
            DFS(L + 1, root.lt);
            DFS(L + 1, root.rt);
        }

    }
}

class Wood {
    int val;
    Wood lt, rt;

    public Wood(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}