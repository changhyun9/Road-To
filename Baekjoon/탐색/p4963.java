package 탐색;

import java.util.Scanner;

public class p4963 {
    /**
     * 나의 구현방법
     * 별다른 로직 없이 DFS로 간단히 풀어지는 문제
     * 가로, 세로, 대각선 으로 움직일 수 있기 때문에
     * 8개의 방향 설정 말고는 일반적인 DFS 문제와 동일
     */
    static int[][] map, visited;
    static int w,h;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        sum += DFS(i, j);
                    }
                }
            }

            System.out.println(sum);
        }
    }

    public static int DFS(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny < h && visited[ny][nx] == 0 && map[ny][nx] == 1) {
                DFS(ny, nx);
            }
        }
        return 1;
    }
}
