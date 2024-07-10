package 탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p11724 {
    /**
     * 처음에 DFS로 접근해서 풀려고 했지만, 하나의 연결요소 엔드 포인트를 잡는 것에 어려웠음.
     * 그래서 return 문으로 접근해서 풀었지만, 연결되지 않은 즉, 하나만 있는 정점에 대해서
     * 개수를 더하는 것에 어려움을 느껴서 BFS로 풀었다. BFS로는 쉽게 풀었다.
     * 아무것도 연결되어 있지 않은 정점에 대해서는 2차원 배열상에서 본인을 가리키는 배열에서
     * 1로 초기화해서 접근을 할 수 있도록 하였다.
     */
    static int n;
    static int[][] arr;
    static List<Integer> visited = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;

        arr = new int[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            int front = sc.nextInt();
            int back = sc.nextInt();
            arr[front][back] = 1;
            arr[back][front] = 1;
        }

        for (int i = 1; i <= n; i++) {
            arr[i][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1 && !visited.contains(j)) {
                    visited.add(j);
                    queue.offer(j);
                }
            }
            int bfs = BFS();
            answer += bfs;
        }

        System.out.println(answer);

    }

    static int BFS() {
        int answer = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[poll][i] == 1 && !visited.contains(i)) {
                    visited.add(i);
                    queue.offer(i);
                }
            }
            answer =1;
        }
        return answer;
    }
}
