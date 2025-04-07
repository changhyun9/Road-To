package Section9;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge1>> arr = new ArrayList<>();
        PriorityQueue<Edge1> pq = new PriorityQueue<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(s).add(new Edge1(e, c));
        }

        pq.offer(new Edge1(1, 0));

        while (!pq.isEmpty()) {
            Edge1 poll = pq.poll();
            int now = poll.vex;
            int nowCost = poll.cost;
            if(nowCost > dis[now]) continue;
            for (Edge1 ob : arr.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge1(ob.vex, nowCost +ob.cost));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + dis[i]);
            }
        }

    }
}

class Edge implements Comparable<Edge1> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge1 o) {
        return this.cost - o.cost;
    }
}