package Simulation;

import java.io.*;
import java.util.*;

public class p14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true){
            if (map[r][c] == 0 && visited[r][c] == 0) {
                visited[r][c] = 1;
                answer++;
            }
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc] == 0) {
                    if (map[nr][nc] == 0) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                while(true){
                    d--;
                    if(d < 0) d=3;
                    int nr = r + dy[d];
                    int nc = c + dx[d];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0 && visited[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
            } else {
                boolean check = false;
                switch (d) {
                    case 0:
                        if (r+1 < n && map[r+1][c] == 0) {
                            check = true;
                            r++;
                        }
                        break;
                    case 1:
                        if (c-1>=0 && map[r][c-1] == 0) {
                            check = true;
                            c--;
                        }
                        break;
                    case 2:
                        if (r-1>=0 && map[r-1][c] == 0) {
                            check = true;
                            r--;
                        }
                        break;
                    default:
                        if (c+1<m && map[r][c+1] == 0) {
                            check = true;
                            c++;
                        }
                }
                if (!check) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}
