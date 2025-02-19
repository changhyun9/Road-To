package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Coord_7576> queue = new LinkedList<>();

        int answer = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new Coord_7576(i,j));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Coord_7576 poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll.x + dx[k];
                int ny = poll.y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    queue.offer(new Coord_7576(nx, ny));
                    map[nx][ny] = map[poll.x][poll.y] + 1;
                    visited[nx][ny] = 1;
                    answer = Math.max(answer, map[nx][ny]);
                }
            }
        }
        answer -= 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer = -1;
                }
            }
        }
        System.out.println(answer);

    }
}


class Coord_7576 {
    int x;
    int y;

    public Coord_7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}