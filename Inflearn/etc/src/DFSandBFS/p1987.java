package DFSandBFS;

import java.io.*;
import java.util.*;

public class p1987 {
    static int r,c, answer;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Character> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = bf.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        DFS(1,0, 0);

        System.out.println(answer);

    }

    static void DFS(int L, int x, int y) {
        answer = Math.max(answer, L);
        list.add(map[y][x]);
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < c && ny >= 0 && ny < r && visited[ny][nx] == 0) {
                if (!list.contains(map[ny][nx])) {
                    DFS(L + 1, nx, ny);
                }
            }
        }
        list.remove(Character.valueOf(map[y][x]));
        visited[y][x] = 0;
    }
}
