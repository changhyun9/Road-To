package Section9;

import java.io.*;
import java.util.*;

// 최소 스패닝 트리 : 크루스칼 (Union & Find)
public class prob7_1 {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        int answer = 0;
        List<Road> list = new ArrayList<>();

        for(int i=1;i<=n; i++)unf[i]=i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Road(v1, v2, cost)); // 출발, 도착, 비용 클래스를 리스트로 저장
        }

        Collections.sort(list); // 비용을 기준으로 오름차순 정렬

        for (Road ob : list) { // 비용 기준으로 오름차순 정렬되어 있기에 최소 비용이 먼저 나옴
            int fa = find(ob.v1); // 출발 노드의 집합 검색
            int fb = find(ob.v2); // 도착 노드의 집합 검색
            if(fa != fb){ // 두 노드가 아직 같은 집합이 아니다. 즉, 아직 최소 스패닝 트리에 속해있지 않다.
                union(fa,fb);
                answer += ob.cost;
            }
        }

        System.out.println(answer);

    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}


class Road implements Comparable<Road>{
    int v1;
    int v2;
    int cost;

    public Road(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public int compareTo(Road ob){
        return this.cost - ob.cost;
    }
}