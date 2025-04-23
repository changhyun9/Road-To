package Section9;

import java.io.*;
import java.util.*;

public class prob8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Node>> list = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int[] ch = new int[v + 1];
        int answer = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.vex;
            if (ch[now] == 0) {
                answer += tmp.cost;
                ch[now] = 1;
            }
            for (Node obj : list.get(now)) {
                if (ch[obj.vex] == 0) {
                    pq.offer(obj);
                }
            }
        }
        System.out.println(answer);
    }
}

class Node implements Comparable<Node> {
    int vex;
    int cost;

    public Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
