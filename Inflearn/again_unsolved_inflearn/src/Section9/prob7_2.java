package Section9;

import java.io.*;
import java.util.*;

public class prob7_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<List<Node2>> list = new ArrayList<>();
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        int[] ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(v1).add(new Node2(v2, cost));
            list.get(v2).add(new Node2(v1, cost));
        }

        pq.offer(new Node2(1, 0));

        while (!pq.isEmpty()) {
            Node2 tmp = pq.poll();
            if(ch[tmp.v] == 0){
                answer += tmp.cost;
                ch[tmp.v] = 1;
                for( Node2 ob : list.get(tmp.v)) {
                    if (ch[ob.v] == 0) {
                        pq.offer(new Node2(ob.v, ob.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

class Node2 implements Comparable<Node2>{
    int v;
    int cost;

    public Node2(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    public int compareTo(Node2 ob){
        return this.cost - ob.cost;
    }
}