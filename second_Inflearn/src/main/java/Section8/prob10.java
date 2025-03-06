package Section8;

import java.io.*;
import java.util.*;

public class prob10 {
    static int[][] map = new int[8][8];
    static int[][] visited = new int[8][8];
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1][1] = 1;
        DFS(1, 1);

        System.out.println(answer);

    }

    static void DFS(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    DFS(nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }

    }
}
