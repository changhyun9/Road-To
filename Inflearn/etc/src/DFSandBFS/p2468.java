package DFSandBFS;

import java.io.*;
import java.util.*;

public class p2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] map = new int[N][N];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int answer = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        boolean flag = true;

        for (; min <= max; min++) {
            Queue<Coord> queue = new LinkedList<>();
            int[][] visited = new int[N][N];
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > min && visited[i][j] == 0) {
                        flag = false;
                        queue.offer(new Coord(i, j));
                        visited[i][j] = 1;
                        while (!queue.isEmpty()) {
                            Coord poll = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = poll.x + dx[k];
                                int ny = poll.y + dy[k];
                                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > min
                                        && visited[nx][ny] == 0) {
                                    visited[nx][ny] = 1;
                                    queue.offer(new Coord(nx, ny));
                                }
                            }
                        }
                        temp++;
                    }
                }
            }
            answer = Math.max(answer, temp);
        }
        if (flag) {
            System.out.println("1");
        } else {
            System.out.println(answer);
        }
    }
}
