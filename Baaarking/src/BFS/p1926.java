package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coord_1926> queue = new LinkedList<>();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    queue.offer(new Coord_1926(i, j));
                    visited[i][j] = 1;
                    int size = 1;
                    answer++;
                    while (!queue.isEmpty()) {
                        Coord_1926 poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if (nx < n && nx >= 0 && ny < m && ny >= 0 && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                                queue.offer(new Coord_1926(nx, ny));
                                visited[nx][ny] = 1;
                                size++;
                            }
                        }
                    }

                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(answer);
        if (max == Integer.MIN_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(max);
        }

    }
}

class Coord_1926{
    int x;
    int y;

    public Coord_1926(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
