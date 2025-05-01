package DFSandBFS;

import java.io.*;
import java.util.*;

public class p15684 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] visited = new int[R][C];

        int answer = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Coord> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String input = bf.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'W') {
                    queue.offer(new Coord(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coord poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'D';
                    } else if (map[nx][ny] == 'S') {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }
        System.out.println(answer + 1);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
