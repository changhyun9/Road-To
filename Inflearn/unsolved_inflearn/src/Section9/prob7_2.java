package Section9;

import java.io.*;
import java.util.*;

public class prob7_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge1>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] ch = new int[n + 1];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new Edge1(v2, cost));
            arr.get(v2).add(new Edge1(v1, cost));
        }

        PriorityQueue<Edge1> pq = new PriorityQueue<>();

        pq.offer(new Edge1(1, 0));

        while (!pq.isEmpty()) {
            Edge1 poll = pq.poll();
            if (ch[poll.vex] == 0) {
                ch[poll.vex] = 1;
                answer += poll.cost;
                for(Edge1 ob : arr.get(poll.vex)){
                    if (ch[ob.vex] == 0) {
                        pq.offer(ob);
                    }
                }
            }
        }

        System.out.println(answer);

    }
}

class Edge1 implements Comparable<Edge1> {
    int vex;
    int cost;

    public Edge1(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge1 ob) {
        return this.cost - ob.cost;
    }
}