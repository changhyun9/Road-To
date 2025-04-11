package Section9;

import java.io.*;
import java.util.*;

public class prob7_1 {
    static int[] unf;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        PriorityQueue<Node1> pq = new PriorityQueue<>();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node1(v1, v2, cost));
        }

        while (!pq.isEmpty()) {
            Node1 tmp = pq.poll();
            if (find(tmp.v1) != find(tmp.v2)) {
                union(tmp.v1, tmp.v2);
                answer += tmp.cost;
            }
        }
        System.out.println(answer);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}

class Node1 implements Comparable<Node1>{
    int v1;
    int v2;
    int cost;

    public Node1(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Node1 node) {
        return this.cost - node.cost;
    }
}