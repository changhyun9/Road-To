package Section8;

import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] map = new int[n][m];
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = map[poll.x][poll.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(flag) break;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, map[i][j]);
                if (map[i][j] == 0) {
                    max = 0;
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(max-1);
    }
}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}