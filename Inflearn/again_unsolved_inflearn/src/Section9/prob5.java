package Section9;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> list = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Edge(e, c));
        }

        Arrays.fill(dis, Integer.MAX_VALUE);

        pq.offer(new Edge(1, 0));
        dis[1] = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost; // 현재 간선까지의 소요 비용

            if(nowCost > dis[now]) continue;
            for (Edge ob : list.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) { // dis[number] -> 현재 number 간선까지의 최소 비용
                    dis[ob.vex] = nowCost + ob.cost; // ob.cost -> 현재 정점에서 vex 까지의 소요 비
                    pq.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i+ " : " + dis[i]);
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}