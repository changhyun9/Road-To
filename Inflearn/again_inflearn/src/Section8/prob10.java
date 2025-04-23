package Section8;

import java.io.*;
import java.util.*;

public class prob10 {
    static int[][] map, visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[7][7];
        visited = new int[7][7];


        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    DFS(nx, ny);
                    visited[nx][ny] = 0;
                }
            }

        }

    }
}
