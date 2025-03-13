package Section7;

import java.util.Scanner;

public class Q11 {
    /**
     * 풀이방법
     * 인접행렬과 방문 배열을 통해 경로탐색을 진행
     * 지점의 수만큼 반복문을 실행하고, 연결되어 있고, 방문하지 않았다면
     * 해당 지점으로 DFS 실행. 이후 하나의 깊이에 모든 경로를 탐색하였다면
     * 방문했던 지점을 미방문으로 변경하여, 나중에 다른 경로로 방문할 수 있도록
     * 해준다.
     */
    static int[][] graph;
    static int[] visited;
    static int N;
    static int M;
    static int answer =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        visited[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int pos) {
        if (pos == N) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (graph[pos][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0;
                }
            }
        }
    }
}
