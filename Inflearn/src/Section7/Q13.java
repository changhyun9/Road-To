package Section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13 {
    /**
     * 나의 구현방법
     * 인접행렬과 방문 배열을 통해서 BFS를 구현하였다
     * 처음 지점을 Queue에 넣어서 해당 지점부터 BFS 탐색을 시작하였고
     * 이미 방문한 지점은 다시 큐에 들어가지 않도록 설정하였다.
     */
    static int N;
    static int M;
    static int[] visited;
    static int[][] graph;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        visited[1] = 1;
        BFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    public static void BFS(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pos);
        int L = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                Integer poll = queue.poll();
                for (int i = 1; i <= N; i++) {
                    if (graph[poll][i] == 1 && visited[i] == 0) {
                        queue.offer(i);
                        visited[i] = 1;
                        answer[i] = L;
                    }
                }
            }
            L++;
        }
    }

    /*public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            Integer cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (visited[nv] == 0) {
                    queue.offer(nv);
                    visited[nv] = 1;
                    answer[nv] = answer[cv] + 1;
                }
            }
        }
    }*/
}
