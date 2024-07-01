package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1012 {
    /**
     * BFS로 문제를 풀었고, 입력되는 값에 따른 x,y 위치를 잡는 부분에서
     * 계속 파악하지 못하고 시간을 끌었다. 구현 부분은 쉽게 했는데 사소한
     * 부분에서 계속해서 시간을 쓰고, 해결하지 못했다.
     */
    static int[][] arr, check;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int z = 0; z < t; z++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            arr = new int[n][m];
            check = new int[n][m];

            int answer = 0;

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (arr[j][l] == 1 && check[j][l] == 0) {
                        check[j][l] = 1;
                        BFS(new Coord(l, j));
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

    }

    static void BFS(Coord coord) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(coord);

        while (!queue.isEmpty()) {
            Coord poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx < m && nx >= 0 && ny < n && ny >= 0 && arr[ny][nx] == 1 && check[ny][nx] == 0) {
                    queue.offer(new Coord(nx, ny));
                    check[ny][nx] = 1;
                }
            }
        }
    }
}

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}