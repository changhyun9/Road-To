package Section8;

import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Tomato> queue = new LinkedList<>();
        boolean first = true;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
                if(map[i][j] == 0) first = false;
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Tomato poll = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = poll.x + dx[k];
                    int ny = poll.y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        queue.offer(new Tomato(nx, ny));
                    }
                }
            }
            cnt++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) flag = true;
            }
        }

        if (first) {
            System.out.println("0");
        }
        else if (flag) {
            System.out.println("-1");
        } else {
            System.out.println(cnt-1);
        }






    }
}

class Tomato{
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}