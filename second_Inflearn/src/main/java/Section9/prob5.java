package Section9;

import java.io.*;
import java.util.*;

public class prob5 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[][] arr = new int[n + 1][n + 1];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(bf.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int e = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//
//            arr[s][e] = c;
//        }
//
//
//        for (int i = 1; i <= n; i++) {
//            if (arr[1][i] > 0) {
//                int cost = arr[1][i];
//                for (int j = 1; j <= n; j++) {
//                    if (arr[i][j] > 0) {
//                        if (arr[1][j] == 0) {
//                            arr[1][j] = cost + arr[i][j];
//                        } else {
//                            arr[1][j] = Math.min(arr[1][j], cost + arr[i][j]);
//                        }
//
//                    }
//                }
//            }
//        }
//
//        for (int i = 2; i <= n; i++) {
//            if (arr[1][i] == 0) {
//                System.out.println("impossible");
//            } else {
//                System.out.println(arr[1][i]);
//            }
//        }
//    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dis = new int[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        pQ.offer(new Edge(1, 0));
        dis[1] = 0;

        while (!pQ.isEmpty()) {
            Edge poll = pQ.poll();
            int now = poll.vex;
            int nowCost = poll.cost;
            if(nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(dis[i]);
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

    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}