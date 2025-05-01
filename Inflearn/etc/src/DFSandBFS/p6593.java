package DFSandBFS;

import java.io.*;
import java.util.*;

public class p6593 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {-1, 1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while (true) {
            String input = bf.readLine();
            if (input.equals("0 0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            char[][][] map = new char[L][R][C];
            int[][][] visited = new int[L][R][C];
            Queue<Floor> queue = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = bf.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = line.charAt(k);
                        if (map[i][j][k] == 'S') {
                            queue.offer(new Floor(i, j, k));
                        }
                    }
                }
                bf.readLine();
            }

            boolean flag = false;

            while (!queue.isEmpty()) {
                Floor poll = queue.poll();
                if (map[poll.z][poll.y][poll.x] == 'E') {
                    System.out.println("Escaped in " + visited[poll.z][poll.y][poll.x] + " minute(s).");
                    flag = true;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int nz = poll.z + dz[i];
                    int ny = poll.y + dy[i];
                    int nx = poll.x + dx[i];

                    if (nz >= 0 && nz < L && ny >= 0 & ny < R && nx >= 0 && nx < C) {
                        if (map[nz][ny][nx] == 'E' || map[nz][ny][nx] == '.') {
                            if(visited[nz][ny][nx] == 0){
                                visited[nz][ny][nx] = visited[poll.z][poll.y][poll.x] + 1;
                                queue.offer(new Floor(nz, ny, nx));
                            }
                        }
                    }
                }
            }
            if(!flag){
                System.out.println("Trapped!");
            }
        }
    }
}

class Floor{
    int z;
    int y;
    int x;

    public Floor(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}