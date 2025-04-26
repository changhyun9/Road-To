package DFSandBFS;

import java.io.*;
import java.util.*;

public class p2583 {
    static int n,m, k;
    static int[][] map, visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            for(int s = y0; s<=y1-1; s++){
                for (int e = x0; e <= x1 - 1; e++) {
                    map[s][e] = 1;
                    visited[s][e] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        Queue<Coord> queue = new LinkedList<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int cnt = 0;
                if (map[y][x] == 0 && visited[y][x] == 0) {
                    queue.offer(new Coord(x, y));
                    visited[y][x] = 1;
                    while (!queue.isEmpty()) {
                        Coord poll = queue.poll();
                        for (int i = 0; i < 4; i++) {
                            int nx = poll.x + dx[i];
                            int ny = poll.y + dy[i];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[ny][nx] == 0 && visited[ny][nx] == 0) {
                                visited[ny][nx] = 1;
                                queue.offer(new Coord(nx, ny));
                                cnt++;
                            }
                        }
                    }
                    list.add(cnt+1);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
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