package Section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q7 {
    /**
     * 나의 구현방법 -> 못품
     * 강의해설 -> MST (최소 비용 신장 트리)를 구성하는 것이 목표.
     * 간선간의 연결정보를 바탕으로 오름차순 정렬을 진행한다. 정렬된 정보를 통해
     * 가장 비용이 작은 것부터 차례대로 추가한다. 이때, 트리는 순환이 되면 안되므로
     * find 메서드를 통해 같은 집합에 속해있으면, 다음으로 진행하고, 그렇지 않은 경우에만
     * union 메서드를 진행한다.
     */

    static int[] unf; // 정점별 포함되는 집합을 나타내기 위한 전역변수

    public static int find(int x) { // 포함되어있는 집합을 찾기 위한 메서드
        if(x == unf[x]) return x;
        else return unf[x] = find(unf[x]); // 대표 집합을 찾기 위한 재귀 호출
    }

    public static void union(int a, int b) { // 같은 집합으로 포함하기 위한 메서드
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb; // 포함되어 있는 집합이 다르면 같은 집합으로 포함
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) unf[i] = i; // 정점 별 초기화 (make-set 단계)

        List<Edge> list = new ArrayList<>();

        for (int i = 1; i <= e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.add(new Edge(v1, v2, cost));
        }

        Collections.sort(list); // kruskal 알고리즘을 수행하기 위해 오름차순으로 정렬

        int cnt = 0; // 비효율적인 호출을 막기 위한 변수, 정점이 n개면 간선의 개수는 n-1이다. 그래서 모든 간선정보를 다 돌기 전에 n-1만큼 트리가
        // 생성되면 반복문을 그만둠.
        int answer = 0;

        for (Edge edge : list) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if (fv1 != fv2) { // 각 정점이 포함되어 있는 집합을 확인하고, 둘이 다르면 순환을 만들지 않기 때문에 Union 진행
                cnt++;
                answer += edge.cost;
                union(edge.v1, edge.v2);
            }
            if (cnt == v - 1) break; // 정점이 n개면 간선이 n-1개. 따라서 간선의 정보를 다 돌기 전에 n-1만큼 간선이 생성되면 종료
        }

        System.out.println(answer);
    }
}

class Edge implements Comparable<Edge>{ // List에 삽입하고, 정렬하기 위해 Comparable 인터페이스 구현

    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) { // cost를 기준으로 오름차순 정렬
        return this.cost - o.cost;
    }
}
