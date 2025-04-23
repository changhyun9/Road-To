package Section8;

import java.io.*;
import java.util.*;

public class prob11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[7][7];
        int[][] visited = new int[7][7];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coord> queue = new LinkedList<>();

        queue.offer(new Coord(0, 0));
        while (!queue.isEmpty()) {
            Coord poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[poll.x][poll.y] + 1;
                    queue.offer(new Coord(nx, ny));
                }
            }
        }

        if (visited[6][6] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(visited[6][6]);
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