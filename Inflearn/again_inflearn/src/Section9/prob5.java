package Section9;

import java.io.*;
import java.util.*;

public class prob5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Road>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int vex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(s).add(new Road(vex, cost));
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Road> pq = new PriorityQueue<>();

        pq.offer(new Road(1, 0));

        while (!pq.isEmpty()) {
            Road poll = pq.poll();
            int now = poll.vex;
            int nowCost = poll.cost;
            if(nowCost > dis[now]) continue;
            for (Road obj : list.get(now)) {
                if (dis[obj.vex] > nowCost + obj.cost) {
                    dis[obj.vex] = nowCost + obj.cost;
                    pq.offer(new Road(obj.vex, dis[obj.vex]));
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

class Road implements Comparable<Road>{
    int vex;
    int cost;

    public Road(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}