package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7569 {
    /**
     * 나의 구현방법
     * 3차원 배열의 BFS로 문제를 풀었는데, 문제의 조건을 제대로 확인하지 못해 M이 가로지만, 세로로
     * N이 세로지만, 가로로 배열을 생성해서 BFS를 진행하였다.
     * 익숙하지 않은 3차원 BFS라 구현하는데 애를 먹었은 것 빼고는 단순 BFS 문제와 똑같이 해결할 수
     * 있었다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[][][] map = new int[H][N][M];
        int[][][] visited = new int[H][N][M];

        int[] dx = {0, 0, -1, 1,0,0};
        int[] dy = {-1,1,0,0,0,0};
        int[] dh = {0,0,0,0,-1,1};

        boolean start = true;
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int num = sc.nextInt();
                    map[i][j][k] = num;
                    if(num ==0) start = false;
                    if(num ==1){
                        queue.offer(new Tomato(i,j,k));
                        visited[i][j][k] = 1;
                    }

                }
            }
        }

        while (!queue.isEmpty()) {
            Tomato poll = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nh = poll.h + dh[i];
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M && map[nh][nx][ny] == 0
                        && visited[nh][nx][ny] == 0) {
                    queue.offer(new Tomato(nh, nx, ny));
                    map[nh][nx][ny] = map[poll.h][poll.x][poll.y] + 1;
                    visited[nh][nx][ny] = 1;

                }
            }
        }

        boolean non = false;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] != -1) {
                        min = Math.max(min, map[i][j][k]);
                    }
                    if (map[i][j][k] == 0) {
                        non = true;
                    }
                }
            }
        }

        if (start) {
            System.out.println("0");
        } else {
            if (non) {
                System.out.println("-1");
            } else {
                System.out.println(min-1);
            }
        }
    }
}

class Tomato {
    int h;
    int x;
    int y;

    public Tomato(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}