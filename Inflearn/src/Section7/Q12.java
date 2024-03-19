package Section7;

import java.util.ArrayList;
import java.util.Scanner;

public class Q12 {
    /**
     * 풀이방법
     * 정점의 수가 많을 때는 인접행렬, 2차원 배열이 아닌 인접리스트, 2차원 리스트를
     * 선언해서 문제를 풀어야 한다. 2차원 리스트는 반복문을 사용해서 new 생성자를 통해서
     * 값을 선언해주어야 한다. 문제풀이 로직은 목표 지점에 도착하면 answer를 ++하고,
     * 그렇지 않으면 리스트 안에 있는 값을 모두 들어가서 DFS를 실행한다.
     * 여기도 마찬가지로 방문 후 다시 원래 메서드로 return이 되었을 때,
     * 방문 기록을 해제해주어야 다음 방문이 가능해진다.
     */
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int N;
    static int M;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        visited[1] = 1;
        DFS(1);

        System.out.println(answer);
    }

    public static void DFS(int pos) {
        if (pos == 5) {
            answer++;
        } else {
            for (Integer integer : graph.get(pos)) {
                if (visited[integer] == 0) {
                    visited[integer] = 1;
                    DFS(integer);
                    visited[integer] = 0;
                }
            }
        }
    }
}
