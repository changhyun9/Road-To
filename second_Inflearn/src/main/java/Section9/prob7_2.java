package Section9;

import java.io.*;
import java.util.*;

public class prob7_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ch = new int[n + 1];
        int answer = 0;

        List<List<Vex>> graph = new ArrayList<>(); // 무방향 그래프를 구현하기 위해 이중리스트 선언

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Vex(v2, cost)); // 무방향 그래프 구현
            graph.get(v2).add(new Vex(v1, cost)); // 무방향 그래프 구현
        }


        PriorityQueue<Vex> queue = new PriorityQueue<>(); //비용을 기준으로 최소 값이 우선순위를 갖도록 설정
        queue.offer(new Vex(1, 0)); // 임의로 1번 노드로 들어가는 비용이 0인 값을 queue에 삽임.
        while (!queue.isEmpty()) {
            Vex poll = queue.poll(); // 최소 비용을 가진 도착 노드 + 비용이 나옴
            if (ch[poll.v] == 0) { // 아직 해당 노드에 도착하는 간선이 없었다면
                ch[poll.v] = 1; // 도착하는 간선이 있다고 체크해주고
                answer += poll.c; // 도착 비용 추가
                for (Vex ob : graph.get(poll.v)) {
                    if(ch[ob.v] == 0) queue.offer(ob); // 도착한 노드에서 뻗어 나갈 수 있는 노드들을 추가.
                }
            }
        }

        System.out.println(answer);
    }

}

class Vex implements Comparable<Vex> {
    int v;
    int c;

    public Vex(int v, int c) {
        this.v = v;
        this.c = c;
    }

    public int compareTo(Vex ob) {
        return this.c - ob.c;
    }
}