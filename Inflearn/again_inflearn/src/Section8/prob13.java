package Section8;

import java.io.*;
import java.util.*;

public class prob13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Island> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    queue.offer(new Island(i, j));
                    while (!queue.isEmpty()) {
                        Island poll = queue.poll();
                        for (int k = 0; k < 8; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                                visited[nx][ny] = 1;
                                queue.offer(new Island(nx, ny));
                            }
                        }
                    }
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}

class Island {
    int x;
    int y;

    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}