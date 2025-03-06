package Section8;

import java.io.*;
import java.util.*;

//DFS
public class prob13_1 {
    static int n, answer;
    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    DFS(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                DFS(nx, ny);
            }
        }

    }
}
