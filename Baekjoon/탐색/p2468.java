package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2468 {
    /**
     * 나의 구현방법
     *
     */
    static int[][] map, visited;
    static int height, N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Coord6> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int answer = 0;


        map = new int[N][N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        for (int k = 0; k <= max; k++) {
            height = k;
            int temp =0 ;
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && visited[i][j] == 0) {
                        BFS(i, j);
                        visited[i][j] = 1;
                        temp++;
                    }
                }
            }
            answer = Math.max(answer, temp);
        }


        System.out.println(answer);

    }

    public static void BFS(int x, int y) {
        queue.offer(new Coord6(x, y));
        while (!queue.isEmpty()) {
            Coord6 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > height && visited[nx][ny] == 0) {
                    queue.offer(new Coord6(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
    }
}

class Coord6 {
    int x;
    int y;

    public Coord6(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
