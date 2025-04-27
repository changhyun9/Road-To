package DFSandBFS;

import java.io.*;
import java.util.*;

public class p2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        char[][] map = new char[n][n];
        int[][] visited = new int[n][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        Queue<Coord> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 1;
                if (map[i][j] == '1' && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.offer(new Coord(i, j));
                    while (!queue.isEmpty()) {
                        Coord poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '1' && visited[nx][ny] == 0) {
                                visited[nx][ny] = 1;
                                queue.offer(new Coord(nx, ny));
                                cnt++;
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer num : list) {
            System.out.println(num);
        }

    }
}

